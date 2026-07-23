function ListofPlayers() {

    const players = [

        { name: "Virat", score: 90 },
        { name: "Rohit", score: 80 },
        { name: "Gill", score: 45 },
        { name: "Rahul", score: 75 },
        { name: "Hardik", score: 60 },
        { name: "Jadeja", score: 72 },
        { name: "Ashwin", score: 55 },
        { name: "Shami", score: 88 },
        { name: "Siraj", score: 67 },
        { name: "Bumrah", score: 91 },
        { name: "Kuldeep", score: 65 }

    ];

    const below70 = players.filter(player => player.score < 70);

    return (

        <div>

            <h2>List of Players</h2>

            <ul>

                {
                    players.map(player => (

                        <li key={player.name}>

                            {player.name} - {player.score}

                        </li>

                    ))
                }

            </ul>

            <h2>Players with Score Below 70</h2>

            <ul>

                {
                    below70.map(player => (

                        <li key={player.name}>

                            {player.name} - {player.score}

                        </li>

                    ))
                }

            </ul>

        </div>

    );

}

export default ListofPlayers;