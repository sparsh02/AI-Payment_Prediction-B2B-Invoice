package highradius.com;

public class InvoiceModel {
	
	    private int Sl_no;
		private String business_code;
		private int cust_number;
		private String name_customer;
		private String clear_date;
		private String business_year;
		private String doc_id;
		private String posting_date;
		private String document_create_date;
		private String due_in_date;
		private String invoice_currency;
		private String document_type;
		private int posting_id;
		private String area_business;
		private double total_open_amount;
		private String baseline_create_date;
		private String cust_payment_terms;
		private long invoice_id;
		private int isOpen;
		private String aging_bucket;
		private Object is_deleted;
		
		
		public InvoiceModel() {
			super();
		}

		public InvoiceModel(int Sl_no,String business_code, int cust_number, String name_customer, String clear_date,
				String business_year, String doc_id, String posting_date, String document_create_date, String due_in_date,
				String invoice_currency, String document_type, int posting_id, String area_business,
				double total_open_amount, String baseline_create_date, String cust_payment_terms, long invoice_id,
				int isOpen) {
			super();
			this.Sl_no=Sl_no;
			this.business_code = business_code;
			this.cust_number = cust_number;
			this.name_customer = name_customer;
			this.clear_date = clear_date;
			this.business_year = business_year;
			this.doc_id = doc_id;
			this.posting_date = posting_date;
			this.document_create_date = document_create_date;
			this.due_in_date = due_in_date;
			this.invoice_currency = invoice_currency;
			this.document_type = document_type;
			this.posting_id = posting_id;
			this.area_business = area_business;
			this.total_open_amount = total_open_amount;
			this.baseline_create_date = baseline_create_date;
			this.cust_payment_terms = cust_payment_terms;
			this.invoice_id = invoice_id;
			this.isOpen = isOpen;
		}	
		
		public int getSl_no() {
			return Sl_no;
		}
		public void setSl_no(int Sl_no) {
			this.Sl_no=Sl_no;
		}

		public String getBusiness_code() {
			return business_code;
		}

		public void setBusiness_code(String business_code) {
			this.business_code = business_code;
		}

		public int getCust_number() {
			return cust_number;
		}

		public void setCust_number(int cust_number2) {
			this.cust_number = cust_number2;
		}

		public String getName_customer() {
			return name_customer;
		}

		public void setName_customer(String name_customer) {
			this.name_customer = name_customer;
		}

		public String getClear_date() {
			return clear_date;
		}

		public void setClear_date(String clear_date) {
			this.clear_date = clear_date;
		}

		public String getBusiness_year() {
			return business_year;
		}

		public void setBusiness_year(String business_year) {
			this.business_year = business_year;
		}

		public String getDoc_id() {
			return doc_id;
		}

		public void setDoc_id(String doc_id2) {
			this.doc_id = doc_id2;
		}

		public String getPosting_date() {
			return posting_date;
		}

		public void setPosting_date(String posting_date) {
			this.posting_date = posting_date;
		}

		public String getDocument_create_date() {
			return document_create_date;
		}

		public void setDocument_create_date(String document_create_date) {
			this.document_create_date = document_create_date;
		}

		public String getDue_in_date() {
			return due_in_date;
		}

		public void setDue_in_date(String due_in_date) {
			this.due_in_date = due_in_date;
		}

		public String getInvoice_currency() {
			return invoice_currency;
		}

		public void setInvoice_currency(String invoice_currency) {
			this.invoice_currency = invoice_currency;
		}

		public String getDocument_type() {
			return document_type;
		}

		public void setDocument_type(String document_type) {
			this.document_type = document_type;
		}

		public int getPosting_id() {
			return posting_id;
		}

		public void setPosting_id(int posting_id) {
			this.posting_id = posting_id;
		}

		public String getArea_business() {
			return area_business;
		}

		public void setArea_business(String area_business) {
			this.area_business = area_business;
		}

		public double getTotal_open_amount() {
			return total_open_amount;
		}

		public void setTotal_open_amount(double d) {
			this.total_open_amount = d;
		}

		public String getBaseline_create_date() {
			return baseline_create_date;
		}

		public void setBaseline_create_date(String baseline_create_date) {
			this.baseline_create_date = baseline_create_date;
		}

		public String getCust_payment_terms() {
			return cust_payment_terms;
		}

		public void setCust_payment_terms(String cust_payment_terms) {
			this.cust_payment_terms = cust_payment_terms;
		}

		public long getInvoice_id() {
			return invoice_id;
		}

		public void setInvoice_id(long invoice_id) {
			this.invoice_id = invoice_id;
		}

		public int getIsOpen() {
			return isOpen;
		}

		public void setIsOpen(int isOpen) {
			this.isOpen = isOpen;
		}
		
		public String getAging_bucket(String aging_bucket) {
			return aging_bucket;
		}

		public void setAging_bucket(String aging_bucket) {
			// TODO Auto-generated method stub
			this.aging_bucket = aging_bucket;
			
		}

		public void setIs_deleted(int is_deleted) {
			this.is_deleted = is_deleted;
			
		}

		

	

	/*	@Override
		public String toString() {
			return "InvoiceModel [Sl_no="+Sl_no +", business_code=" + business_code + ", cust_number=" + cust_number + ", name_customer="
					+ name_customer + ", clear_date=" + clear_date + ", business_year=" + business_year + ", doc_id="
					+ doc_id + ", posting_date=" + posting_date + ", document_create_date=" + document_create_date
					+ ", due_in_date=" + due_in_date + ", invoice_currency=" + invoice_currency + ", document_type="
					+ document_type + ", posting_id=" + posting_id + ", area_business=" + area_business
					+ ", total_open_amount=" + total_open_amount + ", baseline_create_date=" + baseline_create_date
					+ ", cust_payment_terms=" + cust_payment_terms + ", invoice_id=" + invoice_id + ", isOpen=" + isOpen
					+ ", notes=" + "]";
		}
		*/
	}

