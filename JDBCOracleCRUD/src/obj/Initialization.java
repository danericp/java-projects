package obj;

public class Initialization {

	public final static String _DB_SEQ = "user_id_seq";
	public final static String _DB_TABLE = "tb_crud_image";
	public final static String _DB_TABLE_COL1_N_ID = "id";
	public final static String _DB_TABLE_COL2_N_CONTENT = "img_content";
	public final static String _DB_TABLE_COL3_N_NAME = "img_name";
	public final static String _DB_TABLE_COL4_N_DESC = "img_desc";
	public final static String _DB_TABLE_COL5_N_TYPE = "img_type";
	public final static String _DB_TABLE_COL6_N_CREATED = "date_created";

	public final static String _JSON_CREATE = "[\n\t{\"image\": \"\", \"name\": \"\", \"description\": \"\"}\n]";
	public final static String _JSON_READ = "[\n\t{\"image\": \"\", \"name\": \"\", \"description\": \"\"}\n]";
	public final static String _JSON_UPDATE = "[\n\t{\"image\": \"\", \"name\": \"\", \"description\": \"\", \"id\": 0}\n]";
	public final static String _JSON_DELETE = "[\n\t{\"id\": 0}\n]";

	public final static String _CONNECTION = "jdbc:oracle:thin:@localhost:1521:ORCL3";
	public final static String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final static String _PASSWORD = "sys123";
	public final static String _USERNAME = "system";

	public final static String _CREATE = "CREATE";
	public final static String _DELETE = "DELETE";
	public final static String _DROP = "DROP";
	public final static String _READ = "READ";
	public final static String _SETUP = "SETUP";
	public final static String _UPDATE = "UPDATE";

	public final static String _SQL_CREATE = "CREATE TABLE " + _DB_TABLE + " (" +
			_DB_TABLE_COL1_N_ID      + " " + "NUMBER DEFAULT user_id_seq.NEXTVAL PRIMARY KEY, " +
			_DB_TABLE_COL2_N_CONTENT + " " + "BLOB NOT NULL, " +
			_DB_TABLE_COL3_N_NAME    + " " + "VARCHAR(100) NOT NULL, " +
			_DB_TABLE_COL4_N_DESC    + " " + "VARCHAR(200), " +
			_DB_TABLE_COL5_N_TYPE    + " " + "VARCHAR(25), " +
			_DB_TABLE_COL6_N_CREATED + " " + "DATE" +
			")";
	public final static String _SQL_CREATE_SEQ = "CREATE SEQUENCE " + _DB_SEQ + " START WITH 1 INCREMENT BY 1 NOMAXVALUE";
	public final static String _SQL_DROP = "DROP TABLE " + _DB_TABLE;
	public final static String _SQL_DROP_SEQ = "DROP SEQUENCE " + _DB_SEQ;

}
