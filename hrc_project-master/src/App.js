import React from "react";
import AdvancedSearchGrid from "./AdvancedSearchGrid";
import AnalyticsView from "./AnalyticsVIew";
import ButtonRow from "./ButtonRow";
import CustomerIDInfoGrid from "./CustomerIDInfoGrid";
import Footer from "./Footer";
import Header from "./Header";
import InfoGrid from "./InfoGrid";

function App() {
  const [currentSelection, setSelection] = React.useState("");
  let [rows, setRows] = React.useState([]);
  const [selectedRows, selectRow] = React.useState([]);
  const [inputVal, setinputVal] = React.useState("");
  const [predictedRows, setPredictedRows] = React.useState({});

  const [advancedSearchOptions, setAdvancedSearchOptions] = React.useState({
    isactive: false,
  });
  const value = { value: "" };
  console.log(value);

  return (
    <div
      style={{
        position: "relative",
        backgroundColor: "#2C4350",
      }}
    >
      <div>
        <Header />
      </div>
      <div>
        <ButtonRow
          setSelection={setSelection}
          selectedRows={selectedRows}
          inputVal={inputVal}
          predictedRows={predictedRows}
          setPredictedRows={setPredictedRows}
          currentSelection={currentSelection}
          value={value}
          advancedSearchOptions={advancedSearchOptions}
          setAdvancedSearchOptions={setAdvancedSearchOptions}
          setinputVal={setinputVal}
        />
        {advancedSearchOptions.isActive ? (
          <AdvancedSearchGrid
            predictedRows={predictedRows}
            advancedSearchOptions={advancedSearchOptions}
            setRows={setRows}
            selectedRows={selectedRows}
            selectRow={selectRow}

          />
        ) : inputVal.length > 0 ? (
          <CustomerIDInfoGrid
            predictedRows={predictedRows}
            selectedRows={selectedRows}
            selectRow={selectRow}
            setinputVal={setinputVal}
            value={value}
            inputVal={inputVal}
          />
        ) : currentSelection == "b2" ?  <AnalyticsView /> :
        (
            <InfoGrid
              predictedRows={predictedRows}
              rows={rows}
              setRows={setRows}
              selectedRows={selectedRows}
              selectRow={selectRow}
            />
        
        )}
        <Footer />
      </div>
    </div>
  );
}
//

export default App;
