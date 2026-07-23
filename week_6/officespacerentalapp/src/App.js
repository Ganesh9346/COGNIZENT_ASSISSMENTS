import office from "./images/office.jpg";

function App() {

  const offices = [

    {
      id: 1,
      name: "DBS",
      rent: 50000,
      address: "Chennai"
    },

    {
      id: 2,
      name: "Infosys",
      rent: 75000,
      address: "Bangalore"
    },

    {
      id: 3,
      name: "TCS",
      rent: 45000,
      address: "Hyderabad"
    },

    {
      id: 4,
      name: "Cognizant",
      rent: 90000,
      address: "Pune"
    }

  ];

  return (

      <div style={{ marginLeft: "40px" }}>

        <h1>Office Space, at Affordable Range</h1>

        {
          offices.map((officeItem) => (

              <div key={officeItem.id} style={{ marginBottom: "40px" }}>

                <img
                    src={office}
                    alt="Office Space"
                    width="250"
                    height="180"
                />

                <h2>Name: {officeItem.name}</h2>

                <h3
                    style={{
                      color: officeItem.rent < 60000 ? "red" : "green"
                    }}
                >
                  Rent: Rs. {officeItem.rent}
                </h3>

                <h3>Address: {officeItem.address}</h3>

              </div>

          ))
        }

      </div>

  );

}

export default App;