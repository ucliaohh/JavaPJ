package Layout;

import java.sql.*;

public class Layout_001 {
   final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   final static String url = "jdbc:sqlserver://localhost:1435;DatabaseName=KPSNC_MIOT";
    
     public static void main(String[] args) {
         Connection con = null;
         PreparedStatement statement = null;
         ResultSet res = null;
         try {
             Class.forName(cfn);
             con = DriverManager.getConnection(url,"sa","123456");
             
             String sql = "select * from UUMS_USER";
             statement = con.prepareStatement(sql);
             res = statement.executeQuery();
             while(res.next()){
                 String user_name = res.getString("USER_NAME");
                 String user_cn_name = res.getString("USER_CN_NAME");
                 String strSpacex = user_name.length() > 6 ? "\t" : "\t\t";
                 System.out.printf("%s\n", "用户信息： " + user_name.trim() + strSpacex + user_cn_name.trim());
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }finally{
             try {
                 if(res != null) res.close();
                 if(statement != null) statement.close();
                 if(con != null) con.close();
             } catch (Exception e1) {
                e1.printStackTrace();
             }
         }
     }
 }