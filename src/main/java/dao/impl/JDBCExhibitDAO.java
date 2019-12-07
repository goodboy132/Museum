package dao.impl;
import dao.ExhibitDAO;
import dao.mapper.*;
import entity.Author;
import entity.Exhibit;
import entity.Hall;
import entity.Material;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JDBCExhibitDAO implements ExhibitDAO {
  private static JDBCExhibitDAO instance;
  private final Connection connection;


  private JDBCExhibitDAO(Connection connection) {
    this.connection = connection;
  }

  public synchronized static JDBCExhibitDAO getInstance(Connection connection) {
    if (instance == null) {
      instance = new JDBCExhibitDAO(connection);
    }
    return instance;
  }

  @Override
  public Integer save(Exhibit exhibit) {
    String saveExhibitQuery = "INSERT INTO exhibit(exhibit_name,receipt_date,technique,description,author_id,hall_id)"+
            " VALUES(?,?,?,?,?,?)";
    return JDBCCRADDao.save(connection, saveExhibitQuery, exhibit.getName(), exhibit.getReceiptDate(),
            exhibit.getTechnique(), exhibit.getDescription(), exhibit.getAuthor().getId(), exhibit.getHall().getId());
  }

  @Override
  public Integer update(Exhibit exhibit) {
    String updateExhibitQuery = "UPDATE exhibit set exhibit_name = ?, receipt_date = ?, technique = ?," +
            " description = ?, author_id = ?, hall_id = ? WHERE id = ?";
    return JDBCCRADDao.save(connection, updateExhibitQuery, exhibit.getName(), exhibit.getReceiptDate(),
            exhibit.getTechnique(), exhibit.getDescription(), exhibit.getAuthor().getId(), exhibit.getHall().getId(),
            exhibit.getId());
  }

  @Override
  public Integer delete(Exhibit exhibit) {
    String deleteExhibitQuery = "DELETE FROM author where author.id = ?";
    return JDBCCRADDao.update(connection, deleteExhibitQuery, exhibit.getId());
  }


  @Override
  public Optional<Exhibit> getOneById(Long elementId) {
    String getExhibitByIdQuery = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description from exhibit e " +
            "where e.id = ?";
    Optional<Exhibit> exhibit = JDBCCRADDao.getOne(connection, getExhibitByIdQuery, new ExhibitMapper(), elementId);
    exhibit.ifPresent(this::setMappedFieldsToExhibit);
    return exhibit;
  }

  @Override
  public List<Exhibit> getAll() {
    String getAllExhibitsQuery = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description from exhibit e";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllExhibitsQuery, new ExhibitMapper());
    exhibits.forEach(this::setMappedFieldsToExhibit);
    return exhibits;
  }

  @Override
  public List<Exhibit> getAllByAuthor(Long authorId) {
    String getAllExhibitsByAuthor = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description " +
            "from exhibit e where e.author_id = ?";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllExhibitsByAuthor, new ExhibitMapper(), authorId);
    exhibits.forEach(this::setMappedFieldsToExhibit);
    return exhibits;
  }

  @Override
  public List<Exhibit> getAllByWorker(Long workerId) {
    String getAllByWorkerQuery = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description from exhibit e " +
            "join hall h on e.hall_id = h.id join worker_hall wh on h.id = wh.hall_id where wh.worker_id = ?";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllByWorkerQuery, new ExhibitMapper(), workerId);
    exhibits.forEach(this::setMappedFieldsToExhibit);
    return exhibits;
  }
  @Override
  public List<Exhibit> getAllByHole(Long hallId) {
    String getAllByWorkerQuery = "select e.id,exhibit_name,e.receipt_date,e.technique,e.description from exhibit e " +
            "where e.hall_id = ?";
    List<Exhibit> exhibits = JDBCCRADDao.getAll(connection, getAllByWorkerQuery, new ExhibitMapper(), hallId);
    exhibits.forEach(this::setMappedFieldsToExhibit);
    return exhibits;
  }

  @Override
  public Map<String,Integer> getStatisticByMaterial(){
    String getStatisticByMaterialQuery = "SELECT m.material_name as name, count(e.id) as count FROM " +
            "exhibit e JOIN exhibit_material em on e.id = em.exhibit_id join material m on em.material_id = m.id " +
            "group by material_name ";
   return JDBCCRADDao.getOne(connection,getStatisticByMaterialQuery, new StatisticMapper()).get();
  }
  @Override
  public Map<String,Integer> getStatisticByTechnique(){
    String getStatisticByTechnique = "SELECT t.technique_name as name, count(e.id) as count FROM " +
            " exhibit e JOIN exhibit_technique et on e.id = et.exhibit_id join technique t on et.technique_id = t.id "+
            "group by t.technique_name;";
    return JDBCCRADDao.getOne(connection,getStatisticByTechnique, new StatisticMapper()).get();
  }
  @Override
  public Map<String,Integer> getStatisticByAuthor(){
    String getStatisticByTechnique = "SELECT a.surname as name, count(a.id) as count " +
            "FROM exhibit e JOIN author a on a.id = e.author_id group by a.id";
    return JDBCCRADDao.getOne(connection,getStatisticByTechnique, new StatisticMapper()).get();
  }
  @Override
  public Map<String,Integer> getStatisticByHall(){
    String getStatisticByTechnique = "SELECT h.hall_name as name, count(h.id) as count " +
            "FROM exhibit e JOIN hall h on h.id = e.hall_id group by h.id";
    return JDBCCRADDao.getOne(connection,getStatisticByTechnique, new StatisticMapper()).get();
  }


  private void setMappedFieldsToExhibit(Exhibit exhibit) {
    setMaterialsForExhibit(exhibit);
    setAuthorForExhibit(exhibit);
    setHoleForExhibit(exhibit);
  }


  private void setMaterialsForExhibit(Exhibit exhibit) {
    String getMaterialsByExhibitIdQuery = "select * from material  join exhibit_material on material.id = " +
            "exhibit_material.material_id where exhibit_material.exhibit_id = ?";
    List<Material> materials = JDBCCRADDao.getAll
            (connection, getMaterialsByExhibitIdQuery, new MaterialMapper(), exhibit.getId());
    exhibit.setMaterials(materials);
  }

  private void setAuthorForExhibit(Exhibit exhibit) {
    String getAuthorForExhibitQuery = "select * from author join exhibit on author.id = exhibit.author_id where " +
            "exhibit.id = ?";
    Optional<Author> author = JDBCCRADDao.getOne(
            connection, getAuthorForExhibitQuery, new AuthorMapper(), exhibit.getId());
    exhibit.setAuthor(author.get());
  }

  private void setHoleForExhibit(Exhibit exhibit) {
    String getHallForExhibitQuery = "select * from hall join exhibit on hall.id = exhibit.hall_id where " +
            "exhibit.id = ?";
    Optional<Hall> hall = JDBCCRADDao.getOne(connection, getHallForExhibitQuery, new HallMapper(), exhibit.getId());
    exhibit.setHall(hall.get());
  }
}
