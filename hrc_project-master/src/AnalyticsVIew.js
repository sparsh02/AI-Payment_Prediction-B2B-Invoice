import { CircularProgress } from "@mui/material";
import axios from "axios";
import React, { useEffect } from "react";
import Chart from "react-google-charts";

export default function AnalyticsView() {
  const [data, setData] = React.useState([]);
  useEffect(() => {
    axios.get("http://localhost:8080/project/graphfetch").then((a) => {
      const d = [["Business", "Customers", "Open Count"]];
      a.data.forEach((e) =>
        d.push([e.business_code, e.customers, e.openCount])
      );
      console.log(d);
      setData(d);
    });
  }, []);

  return (
    <div style={{ height: "72vh", width: "50%", color: "#293C4A" }}>
      {data.length == 0 ? (
        <div
          style={{
            paddingTop: "5vh",
            marginLeft: "50%",
          }}
        >
          <CircularProgress> </CircularProgress>{" "}
        </div>
      ) : (
        <Chart
          style={{
            marginLeft: "10vh",
            marginTop: "10vh",
          }}
          options={{
            chart: {
              title: "Analytic View",
            },
            is3D: true,
          }}
          columns={["U001", "U001", "U001", "U001", "U001", "U001"]}
          chartType="Bar"
          data={data}
          width="100%"
          height="400px"
          legendToggle
        />
      )}
    </div>
  );
}
