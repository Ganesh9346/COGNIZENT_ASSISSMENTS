function BookDetails() {

    const books = [

        {
            id: 1,
            title: "Java Programming",
            author: "James Gosling"
        },

        {
            id: 2,
            title: "Spring Boot",
            author: "Craig Walls"
        },

        {
            id: 3,
            title: "React",
            author: "Jordan Walke"
        }

    ];

    return (

        <div>

            <h2>Book Details</h2>

            <ul>

                {

                    books.map(book => (

                        <li key={book.id}>

                            <b>{book.title}</b> - {book.author}

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default BookDetails;