import { useState } from "react";

function CurrencyConverter() {

    const [rupees, setRupees] = useState("");
    const [euro, setEuro] = useState("");

    const handleSubmit = (event) => {

        event.preventDefault();

        const converted = (parseFloat(rupees) / 90).toFixed(2);

        setEuro(converted);

        alert("Converted Amount is " + converted + " Euro");

    };

    return (

        <div>

            <h1 style={{ color: "green" }}>Currency Convertor!!!</h1>

            <form onSubmit={handleSubmit}>

                <div>

                    <label>Amount : </label>

                    <input
                        type="number"
                        value={rupees}
                        onChange={(e) => setRupees(e.target.value)}
                    />

                </div>

                <br />

                <div>

                    <label>Currency : </label>

                    <input
                        type="text"
                        value={euro}
                        readOnly
                    />

                </div>

                <br />

                <button type="submit">

                    Submit

                </button>

            </form>

        </div>

    );

}

export default CurrencyConverter;