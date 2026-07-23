function BlogDetails() {

    const blogs = [

        {
            id: 1,
            title: "React Hooks",
            author: "Ganesh"
        },

        {
            id: 2,
            title: "Spring Security",
            author: "John"
        }

    ];

    return (

        <div>

            <h2>Blog Details</h2>

            <ul>

                {

                    blogs.map(blog => (

                        <li key={blog.id}>

                            <b>{blog.title}</b> - {blog.author}

                        </li>

                    ))

                }

            </ul>

        </div>

    );

}

export default BlogDetails;