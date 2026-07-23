import { useState } from "react";

import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {

  const [page, setPage] = useState("book");

  return (

      <div style={{ margin: "30px" }}>

        <h1>Blogger App</h1>

        <button onClick={() => setPage("book")}>

          Books

        </button>

        <button
            onClick={() => setPage("blog")}
            style={{ marginLeft: "10px" }}
        >

          Blogs

        </button>

        <button
            onClick={() => setPage("course")}
            style={{ marginLeft: "10px" }}
        >

          Courses

        </button>

        <hr />

        {

          page === "book" ?

              <BookDetails />

              :

              page === "blog" ?

                  <BlogDetails />

                  :

                  <CourseDetails />

        }

      </div>

  );

}

export default App;