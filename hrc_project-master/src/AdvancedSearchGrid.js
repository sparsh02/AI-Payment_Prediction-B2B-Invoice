import { DataGrid } from "@mui/x-data-grid";
import React from "react";

export default function AdvancedSearchGrid({
  advancedSearchOptions,
  selectedRows,
  selectRow,
  predictedRows,
}) {
  const [rows, setRows] = React.useState([]);
  const [loading, setloading] = React.useState(false);
  console.log(selectedRows + " FF ");
  React.useEffect(async () => {
    let mounted = true;
    if (mounted)
      try {
        setloading(true);
        let response = await fetch("http://localhost:8080/Highradius_Final/AdvanceSearch", {
          method: "POST",
          body: JSON.stringify(advancedSearchOptions),
        });
        let l = await response.json();
        console.log(l);
        if (response.ok) {
          let c = [];
          console.log(l);
          for (const data of l) {
            let doc = Object.keys(data).reduce((a, b) => {
              a[b] = data[b];
              return a;
            }, {});


            c.push(doc);
          }
          console.log("C");
          console.log(predictedRows);
          for (const [key, val] of Object.entries(predictedRows)) {
            let index = c.findIndex((e) => e.Sl_no == key);
            if (index > -1)
              c[index].predicted_date = val;
          }

          setRows(c);
          setloading(false);

          //  setCustIDVisible(false);
        } else {
          throw "Error";
        }
      } catch (error) {
        console.log(error);
        setRows([]);
        setloading(false);

        // setCustIDVisible(false);
        console.log(error);
      }
    return () => mounted = false;
  }, [predictedRows]);

  const columns = [
    { field: "Sl_no", headerName: "Sl no", width: 140 },
    { field: "cust_number", headerName: "Customer Number", width: 140 },
    {
      field: "Customer Name",
      headerName: "name_customer",
      width: 140,
      hidden: true,
    },

    {
      field: "baseline_create_date",
      headerName: "Baseline Create Date",
      width: 140,
    },
    { field: "business_code", headerName: "Business Code", width: 140 },
    { field: "clear_date", headerName: "Clear Date", width: 140 },
    { field: "posting_id", headerName: "Posting Id", width: 140 },
    // { field: "area_business", headerName: "Area Business", width: 140 },
    { field: "doc_id", headerName: "Document Id", width: 140 },
    {
      field: "cust_payment_terms",
      headerName: "Customer Payment Terms",
      width: 140,
    },
    // { field: "is_deleted", headerName: "Is Deleted", width: 140 },
    { field: "buisness_year", headerName: "Buisness Year", width: 140 },
    {
      field: "document_create_date1",
      headerName: "Document Create Date 1",
      width: 140,
    },
    { field: "invoice_id", headerName: "Invoice Id", width: 140 },
    {
      field: "document_create_date",
      headerName: "Document Create Date",
      width: 140,
    },
    { field: "total_open_amount", headerName: "Total Open Amount", width: 140 },
    { field: "posting_date", headerName: "Posting Date", width: 140 },
    { field: "invoice_currency", headerName: "Invoice Currency", width: 140 },
    { field: "due_in_date", headerName: "Due In Date", width: 140 },
    { field: "document_type", headerName: "Document Type", width: 140 },
    { field: "isopen", headerName: "Is Open", width: 140 },
    { field: "predicted_date", headerName: "Predicted Date", width: 140 },
  ];

  return (
    <div style={{ height: "72vh", width: "100%", color: "#293C4A" }}>
      {false ? (
        <div></div>
      ) : (
        <DataGrid
          selectionModel={selectedRows.map((e) => e.Sl_no)}
          onSelectionModelChange={(ids) => {
            selectRow(rows.filter((e) => ids.indexOf(e.Sl_no) > -1));
          }}
          sx={{
            "& .MuiToolbar-root": {
              color: "white",
            },
            border: "none",
            backgroundColor: "#293C4A",
            color: "white",
            "& .MuiDataGrid-columnSeparator--sideRight": {
              display: "none",
            },
            "& .MuiDataGrid-columnHeaderTitle": {
              color: "white",

              textOverflow: "clip",
              whiteSpace: "break-spaces",
              lineHeight: 1,
            },
          }}
          getRowId={(row) => row.Sl_no}
          rowsPerPageOptions={[5, 10, 15, 25, 50, 100]}
          rows={rows}
          columns={columns}
          checkboxSelection
        />
      )}
    </div>
  );
}
