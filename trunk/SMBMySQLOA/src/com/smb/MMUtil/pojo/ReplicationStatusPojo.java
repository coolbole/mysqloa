/**
 * 
 */
package com.smb.MMUtil.pojo;

/**
 * @author huangyi
 * 
 */
public class ReplicationStatusPojo {

	private String slave_IO_State;
	private String master_Host;
	private String master_User;
	private String master_Port;
	private String connect_Retry;
	private String master_Log_File;
	private String read_Master_Log_Pos;
	private String relay_Log_File;
	private String relay_Log_Pos;
	private String relay_Master_Log_File;
	private String slave_IO_Running;
	private String slave_SQL_Running;
	private String replicate_Do_DB;
	private String replicate_Ignore_DB;
	private String replicate_Do_Table;
	private String replicate_Ignore_Table;
	private String replicate_Wild_Do_Table;
	private String replicate_Wild_Ignore_Table;
	private String last_Errno;
	private String last_Error;
	private String skip_Counter;
	private String exec_Master_Log_Pos;
	private String relay_Log_Space;
	private String until_Condition;
	private String until_Log_File;
	private String until_Log_Pos;
	private String master_SSL_Allowed;
	private String master_SSL_CA_File;
	private String master_SSL_CA_Path;
	private String master_SSL_Cert;
	private String master_SSL_Cipher;
	private String master_SSL_Key;
	private String seconds_Behind_Master;
	private String master_SSL_Verify_Server_Cert;
	private String last_IO_Errno;
	private String last_IO_Error;
	private String last_SQL_Errno;
	private String last_SQL_Error;
	private String master_Bind;
	private String masterFile;
	private String masterPosition;
	private String masterBinlog_Do_DB;
	private String masterBinlog_Ignore_DB;
	
	
	public String getMasterFile() {
		return masterFile;
	}
	public void setMasterFile(String masterFile) {
		this.masterFile = masterFile;
	}
	public String getMasterPosition() {
		return masterPosition;
	}
	public void setMasterPosition(String masterPosition) {
		this.masterPosition = masterPosition;
	}
	public String getMasterBinlog_Do_DB() {
		return masterBinlog_Do_DB;
	}
	public void setMasterBinlog_Do_DB(String masterBinlog_Do_DB) {
		this.masterBinlog_Do_DB = masterBinlog_Do_DB;
	}
	public String getMasterBinlog_Ignore_DB() {
		return masterBinlog_Ignore_DB;
	}
	public void setMasterBinlog_Ignore_DB(String masterBinlog_Ignore_DB) {
		this.masterBinlog_Ignore_DB = masterBinlog_Ignore_DB;
	}
	public String getSlave_IO_State() {
		return slave_IO_State;
	}
	public void setSlave_IO_State(String slave_IO_State) {
		this.slave_IO_State = slave_IO_State;
	}
	public String getMaster_Host() {
		return master_Host;
	}
	public void setMaster_Host(String master_Host) {
		this.master_Host = master_Host;
	}
	public String getMaster_User() {
		return master_User;
	}
	public void setMaster_User(String master_User) {
		this.master_User = master_User;
	}
	public String getMaster_Port() {
		return master_Port;
	}
	public void setMaster_Port(String master_Port) {
		this.master_Port = master_Port;
	}
	public String getConnect_Retry() {
		return connect_Retry;
	}
	public void setConnect_Retry(String connect_Retry) {
		this.connect_Retry = connect_Retry;
	}
	public String getMaster_Log_File() {
		return master_Log_File;
	}
	public void setMaster_Log_File(String master_Log_File) {
		this.master_Log_File = master_Log_File;
	}
	public String getRead_Master_Log_Pos() {
		return read_Master_Log_Pos;
	}
	public void setRead_Master_Log_Pos(String read_Master_Log_Pos) {
		this.read_Master_Log_Pos = read_Master_Log_Pos;
	}
	public String getRelay_Log_File() {
		return relay_Log_File;
	}
	public void setRelay_Log_File(String relay_Log_File) {
		this.relay_Log_File = relay_Log_File;
	}
	public String getRelay_Log_Pos() {
		return relay_Log_Pos;
	}
	public void setRelay_Log_Pos(String relay_Log_Pos) {
		this.relay_Log_Pos = relay_Log_Pos;
	}
	public String getRelay_Master_Log_File() {
		return relay_Master_Log_File;
	}
	public void setRelay_Master_Log_File(String relay_Master_Log_File) {
		this.relay_Master_Log_File = relay_Master_Log_File;
	}
	public String getSlave_IO_Running() {
		return slave_IO_Running;
	}
	public void setSlave_IO_Running(String slave_IO_Running) {
		this.slave_IO_Running = slave_IO_Running;
	}
	public String getSlave_SQL_Running() {
		return slave_SQL_Running;
	}
	public void setSlave_SQL_Running(String slave_SQL_Running) {
		this.slave_SQL_Running = slave_SQL_Running;
	}
	public String getReplicate_Do_DB() {
		return replicate_Do_DB;
	}
	public void setReplicate_Do_DB(String replicate_Do_DB) {
		this.replicate_Do_DB = replicate_Do_DB;
	}
	public String getReplicate_Ignore_DB() {
		return replicate_Ignore_DB;
	}
	public void setReplicate_Ignore_DB(String replicate_Ignore_DB) {
		this.replicate_Ignore_DB = replicate_Ignore_DB;
	}
	public String getReplicate_Do_Table() {
		return replicate_Do_Table;
	}
	public void setReplicate_Do_Table(String replicate_Do_Table) {
		this.replicate_Do_Table = replicate_Do_Table;
	}
	public String getReplicate_Ignore_Table() {
		return replicate_Ignore_Table;
	}
	public void setReplicate_Ignore_Table(String replicate_Ignore_Table) {
		this.replicate_Ignore_Table = replicate_Ignore_Table;
	}
	public String getReplicate_Wild_Do_Table() {
		return replicate_Wild_Do_Table;
	}
	public void setReplicate_Wild_Do_Table(String replicate_Wild_Do_Table) {
		this.replicate_Wild_Do_Table = replicate_Wild_Do_Table;
	}
	public String getReplicate_Wild_Ignore_Table() {
		return replicate_Wild_Ignore_Table;
	}
	public void setReplicate_Wild_Ignore_Table(String replicate_Wild_Ignore_Table) {
		this.replicate_Wild_Ignore_Table = replicate_Wild_Ignore_Table;
	}
	public String getLast_Errno() {
		return last_Errno;
	}
	public void setLast_Errno(String last_Errno) {
		this.last_Errno = last_Errno;
	}
	public String getLast_Error() {
		return last_Error;
	}
	public void setLast_Error(String last_Error) {
		this.last_Error = last_Error;
	}
	public String getSkip_Counter() {
		return skip_Counter;
	}
	public void setSkip_Counter(String skip_Counter) {
		this.skip_Counter = skip_Counter;
	}
	public String getExec_Master_Log_Pos() {
		return exec_Master_Log_Pos;
	}
	public void setExec_Master_Log_Pos(String exec_Master_Log_Pos) {
		this.exec_Master_Log_Pos = exec_Master_Log_Pos;
	}
	public String getRelay_Log_Space() {
		return relay_Log_Space;
	}
	public void setRelay_Log_Space(String relay_Log_Space) {
		this.relay_Log_Space = relay_Log_Space;
	}
	public String getUntil_Condition() {
		return until_Condition;
	}
	public void setUntil_Condition(String until_Condition) {
		this.until_Condition = until_Condition;
	}
	public String getUntil_Log_File() {
		return until_Log_File;
	}
	public void setUntil_Log_File(String until_Log_File) {
		this.until_Log_File = until_Log_File;
	}
	public String getUntil_Log_Pos() {
		return until_Log_Pos;
	}
	public void setUntil_Log_Pos(String until_Log_Pos) {
		this.until_Log_Pos = until_Log_Pos;
	}
	public String getMaster_SSL_Allowed() {
		return master_SSL_Allowed;
	}
	public void setMaster_SSL_Allowed(String master_SSL_Allowed) {
		this.master_SSL_Allowed = master_SSL_Allowed;
	}
	public String getMaster_SSL_CA_File() {
		return master_SSL_CA_File;
	}
	public void setMaster_SSL_CA_File(String master_SSL_CA_File) {
		this.master_SSL_CA_File = master_SSL_CA_File;
	}
	public String getMaster_SSL_CA_Path() {
		return master_SSL_CA_Path;
	}
	public void setMaster_SSL_CA_Path(String master_SSL_CA_Path) {
		this.master_SSL_CA_Path = master_SSL_CA_Path;
	}
	public String getMaster_SSL_Cert() {
		return master_SSL_Cert;
	}
	public void setMaster_SSL_Cert(String master_SSL_Cert) {
		this.master_SSL_Cert = master_SSL_Cert;
	}
	public String getMaster_SSL_Cipher() {
		return master_SSL_Cipher;
	}
	public void setMaster_SSL_Cipher(String master_SSL_Cipher) {
		this.master_SSL_Cipher = master_SSL_Cipher;
	}
	public String getMaster_SSL_Key() {
		return master_SSL_Key;
	}
	public void setMaster_SSL_Key(String master_SSL_Key) {
		this.master_SSL_Key = master_SSL_Key;
	}
	public String getSeconds_Behind_Master() {
		return seconds_Behind_Master;
	}
	public void setSeconds_Behind_Master(String seconds_Behind_Master) {
		this.seconds_Behind_Master = seconds_Behind_Master;
	}
	public String getMaster_SSL_Verify_Server_Cert() {
		return master_SSL_Verify_Server_Cert;
	}
	public void setMaster_SSL_Verify_Server_Cert(
			String master_SSL_Verify_Server_Cert) {
		this.master_SSL_Verify_Server_Cert = master_SSL_Verify_Server_Cert;
	}
	public String getLast_IO_Errno() {
		return last_IO_Errno;
	}
	public void setLast_IO_Errno(String last_IO_Errno) {
		this.last_IO_Errno = last_IO_Errno;
	}
	public String getLast_IO_Error() {
		return last_IO_Error;
	}
	public void setLast_IO_Error(String last_IO_Error) {
		this.last_IO_Error = last_IO_Error;
	}
	public String getLast_SQL_Errno() {
		return last_SQL_Errno;
	}
	public void setLast_SQL_Errno(String last_SQL_Errno) {
		this.last_SQL_Errno = last_SQL_Errno;
	}
	public String getLast_SQL_Error() {
		return last_SQL_Error;
	}
	public void setLast_SQL_Error(String last_SQL_Error) {
		this.last_SQL_Error = last_SQL_Error;
	}
	public String getMaster_Bind() {
		return master_Bind;
	}
	public void setMaster_Bind(String master_Bind) {
		this.master_Bind = master_Bind;
	}

	
	
	
	
}
