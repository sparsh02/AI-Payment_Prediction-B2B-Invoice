package highradius.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


@WebServlet("/InvoiceCrude")
public class InvoiceCrude extends HttpServlet {
		private static final long serialVersionUID = 1L;
		private static Connection conn = null;
		private static PreparedStatement stmt = null;
	       
	    public InvoiceCrude() {
	        super();
	        
	    }
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
			
			
			

			int page = Integer.parseInt(request.getParameter("page"));
			int records_per_page = 12;
			
			HashMap<Object, Object> Response = new HashMap<Object, Object>();
			
			ArrayList<InvoiceModel> data = new ArrayList<InvoiceModel>();
			
			try {
				conn = dbconnection.dbconnector();
				stmt = conn.prepareStatement(
						"SELECT * FROM winter_internship LIMIT " +(page-1)*records_per_page+","+records_per_page
						);
		
				ResultSet rs = stmt.executeQuery();		
				while(rs.next()) {
					InvoiceModel w = new InvoiceModel();
////					pojo.setCust_number(result.getString(2));
////					pojo.setName_customer(result.getString(3));
////					pojo.setDoc_id(result.getLong(6));
////					pojo.setDue_in_date(result.getString(9));
////					pojo.setTotal_open_amount(result.getDouble(14));
////					pojo.setInvoice_id(result.getLong(17));
//
//					pojo.setSl_no(result.getString(1));
//					pojo.setBusiness_code(result.getString(2));
//					pojo.setCust_number(result.getString(3));
//					//pojo.setName_customer(result.getString(4));
//					pojo.setClear_date(result.getString(5));
//					pojo.setBusiness_year(result.getString(6));
//					pojo.setDoc_id(result.getLong(7));
//					pojo.setPosting_date(result.getString(8));
//					pojo.setDocument_create_date(result.getString(9));
//					pojo.setDue_in_date(result.getString(11));
//					pojo.setInvoice_currency(result.getString(12));
//					pojo.setDocument_type(result.getString(13));
//					pojo.setPosting_id(result.getInt(14));
//					//pojo.setArea_business(result.getString(15));
//					pojo.setTotal_open_amount(result.getDouble(16));
//					pojo.setBaseline_create_date(result.getString(17));
//					pojo.setCust_payment_terms(result.getString(18));
//					pojo.setInvoice_id(result.getLong(19));
//					pojo.setIsOpen(result.getInt(20));
//					
//					
//					data.add(pojo);
					
					
					int sl_no = rs.getInt("sl_no");
					String business_code = rs.getString("business_code");
					int cust_number = rs.getInt("cust_number");
					String clear_date = rs.getString("clear_date");
					String buisness_year = rs.getString("buisness_year");
					String doc_id = rs.getString("doc_id");
					String posting_date = rs.getString("posting_date");
					String document_create_date = rs.getString("document_create_date");
					String document_create_date1 = rs.getString("document_create_date1");
					String due_in_date = rs.getString("due_in_date");
					String invoice_currency = rs.getString("invoice_currency");
					String document_type = rs.getString("document_type");
					int posting_id = rs.getInt("posting_id");
					String area_business = rs.getString("area_business");
					double total_open_amount = rs.getDouble("total_open_amount");
					String baseline_create_date = rs.getString("baseline_create_date");
					String cust_payment_terms = rs.getString("cust_payment_terms");
					int invoice_id = rs.getInt("invoice_id");
					int isOpen = rs.getInt("isOpen");
					String aging_bucket = rs.getString("aging_bucket");
					int is_deleted = rs.getInt("is_deleted");

					w.setSl_no(sl_no);
					w.setBusiness_code(business_code);
					w.setCust_number(cust_number);
					w.setClear_date(clear_date);
//					w.setBusiness_year(buisness_year);
					w.setBusiness_year(buisness_year);
					w.setDoc_id(doc_id);
					w.setPosting_date(posting_date);
					w.setDocument_create_date(document_create_date);
//					w.setDocument_create_date1(document_create_date1);
					w.setDue_in_date(due_in_date);
					w.setInvoice_currency(invoice_currency);
					w.setDocument_type(document_type);
					w.setPosting_id(posting_id);
					w.setArea_business(area_business);
					w.setTotal_open_amount(total_open_amount);
					w.setBaseline_create_date(baseline_create_date);
					w.setCust_payment_terms(cust_payment_terms);
					w.setInvoice_id(invoice_id);
					w.setIsOpen(isOpen);
					w.setAging_bucket(aging_bucket);
					w.setIs_deleted(is_deleted);

					data.add(w);
				}
				Response.put("data", data);
				Gson gson = new Gson();
				String resData = gson.toJson(data);
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setHeader("Access-Control-Allow-Origin", "*");
				out.print(resData);
				out.flush();
				
				
				
				rs.close();
				stmt.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			try {
				String req_body = request.getReader().lines()
					    .reduce("", (accumulator, actual) -> accumulator + actual);
				System.out.println(req_body);
				
				HashMap<String, String> req_body_map = new Gson().fromJson(
														req_body, new TypeToken<HashMap<String, String>>(){}.getType()
													);
				System.out.println(req_body_map);
				
				conn = dbconnection.dbconnector();
				String INSERT_QUERY = "INSERT INTO winter_intrnship(name_customer,cust_number,invoice_id,total_open_amount,"
						+ "due_in_date,doc_id,notes) VALUES(?,?,?,?,?,?,?)";
				stmt = conn.prepareStatement(INSERT_QUERY);
				
				stmt.setString(1, req_body_map.get("name_customer"));
				stmt.setString(2, req_body_map.get("cust_number"));
				stmt.setLong(3, Long.parseLong(req_body_map.get("invoice_id")));
				stmt.setDouble(4, Double.parseDouble(req_body_map.get("total_open_amount")));
				stmt.setString(5, req_body_map.get("due_in_date"));
				//stmt.setLong(6, Long.parseLong(req_body_map.get("invoice_id")));
				if(req_body_map.get("notes").equals("")) {
					stmt.setNull(6, Types.NULL);
				} else {
					stmt.setString(6, req_body_map.get("notes"));
				}
				
				stmt.executeUpdate();
				
				stmt.close();
				
			} catch(Exception e) {
				System.out.println("ERROR OCCURED WHILE INSERTING A NEW RECORD");
				System.out.println(e.getMessage());
			}
		}

		protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				String req_body = request.getReader().lines()
					    .reduce("", (accumulator, actual) -> accumulator + actual);
				System.out.println(req_body);
				
				HashMap<String, String> req_body_map = new Gson().fromJson(
														req_body, new TypeToken<HashMap<String, String>>(){}.getType()
													);
				System.out.println(req_body_map);
				
				conn = dbconnection.dbconnector();
				String UPDATE_QUERY = "UPDATE winter_internship SET total_open_amount = ?, notes = ? WHERE doc_id = ?";
				stmt = conn.prepareStatement(UPDATE_QUERY);
				
				stmt.setDouble(1, Double.parseDouble(req_body_map.get("total_open_amount")));
				stmt.setString(2, req_body_map.get("notes"));
				stmt.setLong(3, Long.parseLong(req_body_map.get("doc_id")));
				
				stmt.executeUpdate();
				
				stmt.close();
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
				response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
		}

		protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			try {
				String req_body = request.getReader().lines()
					    .reduce("", (accumulator, actual) -> accumulator + actual);
				System.out.println(req_body);
				
				HashMap<String, String[]> req_body_map = new Gson().fromJson(
														req_body, new TypeToken<HashMap<String, String[]>>(){}.getType()
													);
				
				List<String> list = new ArrayList<String>();
				list.addAll(Arrays.asList(req_body_map.get("doc_ids")));

				String docIds = (String) list.stream().collect(Collectors.joining(",","(",")"));
				
				conn = dbconnection.dbconnector();
				String DELETE_QUERY = "DELETE FROM winter_internship WHERE doc_id IN " + docIds;
				System.out.println(DELETE_QUERY);
				stmt = conn.prepareStatement(DELETE_QUERY);
				
				stmt.executeUpdate();
				
				stmt.close();
				
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

}
