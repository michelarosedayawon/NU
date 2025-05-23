
<?php
$servername = "localhost";
$username = "root";  // Default XAMPP username
$password = "";      // Default is empty for XAMPP
$database = "gpa_tracker";

// Connect to MySQL
$conn = new mysqli($servername, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Handle login form submission
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST['name'];
    $studentID = $_POST['studentID'];

    // Validate user
    $sql = "SELECT * FROM students WHERE studentID = '$studentID' AND name = '$name'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        echo "Login successful!";
        // Redirect to the tracker page
        header("Location: Trackerpage.php");
        exit();
    } else {
        echo "Invalid Student ID or Name!";
    }
}
$conn->close();
?>





<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>EduTrackr</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    
    <style>
        html, body {
            overflow-x: hidden;
            width: 100%;
            height: 100%;
        }
        body {
            margin: 0;
            font-family: 'Poppins', sans-serif;
            background-color: rgb(179, 152, 117);
            text-align: center;
            display: flex;
            flex-direction: column;
            align-items: center;
            min-height: 100vh;
            overflow-y: hidden;
        }
        .navbar {
            display: flex;
            justify-content: center;
            align-items: center;
            gap: 50px;
            background: rgb(123, 103, 76);
            border-radius: 50px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            top: 30px;
            z-index: 1000;
            width: 80%;
            max-width: 1200px;
            padding: 12px 30px;
            transition: all 0.2s ease-in-out;
            font-size: 16px;
            flex-wrap: wrap;
        }
        .navbar a {
            text-decoration: none;
            color: black;
            font-weight: 500;
            padding: 10px 25px;
            border-radius: 20px;
            transition: all 0.2s ease-in-out;
        }
        .navbar a.active, .navbar a:hover {
            background: linear-gradient(120deg, rgb(171, 152, 127), rgb(123, 103, 76));
            color: white;
        }
        .hero {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-top: 50px;
            height: 50vh;
            color: white;
        }
        .hero h2 {
            color: black;
            font-size: 25px;
        }
        .hero h1 {
            font-size: 90px;
            font-weight: 700;
        }
        .hero span {
            color: rgb(0, 0, 0);
            font-weight: 700;
        }
        .login-btn {
            background: rgb(94, 74, 47);
            color: white;
            font-size: 18px;
            font-weight: bold;
            border: none;
            padding: 12px 24px;
            border-radius: 25px;
            margin-top: 20px;
            cursor: pointer;
            transition: all 0.3s ease;
        }
        .login-btn:hover {
            background: rgb(123, 103, 76);
        }
        .modal-content {
            background-color: rgb(94, 74, 47);
            color: white; 
            border-radius: 15px;
        }
        .modal-header {
            border-bottom: 2px solid white;
            display: flex;
            justify-content: center; 
            width: 100%;
        }
        .modal-title {
           font-weight: bold;
           flex-grow: 1; 
            text-align: center;
        }
        .modal-body {
            background: rgb(123, 103, 76);
            border-radius: 0 0 15px 15px;
            text-align: left;
        }
         .btn-custom {
            background-color: #4e3d31; 
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 8px;
            width: 150px;
            transition: background 0.3s ease;
        }
        .btn-custom:hover {
            background-color: #7a3010; 
        }
        .bookshelf {
            display: grid;
            grid-gap: 15px;
            padding-bottom: 0px;
            width: 100%;
            max-width: 100%;
            justify-content: center;
            align-items: flex-end;
        }
        .book {
            height: 260px;
            width: 30px;
            background: linear-gradient(120deg, #c79060, #a65b2c); /* default book colorrr */
            border-radius: 8px;
            position: relative;
            overflow: hidden;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15); /* shadow for depth, johnny depth?! emz */
            transition: transform 0.5s ease, box-shadow 0.3s ease-out, margin-top 0.3s ease-out;
        }
        /* Book Spine */
        .book::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 30px;
            height: 100%;
            background: rgb(94, 74, 47);
            box-shadow: 2px 0 8px rgba(0, 0, 0, 0.2);
        }
        /* hover effect */
        .book:hover {
            transform: translateY(-35px); 
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            margin-top: -30px; 
        }
        /* color ng mga book */
        .book:nth-child(odd) {
            background: linear-gradient(120deg, #607c8d, #455a64);
        }
        .book:nth-child(even) {
            background: linear-gradient(120deg, #8c4d1f, #7a3010);
        }
        .book:nth-child(3n) {
            background: linear-gradient(120deg, #3b7f6b, #2c5d48);
        }
        .book:nth-child(4n) {
            background: linear-gradient(120deg, #f2c85b, #f2a900);
        }
        .book:hover::after {
            opacity: 1;
        }
        @media (max-width: 1200px) {
            .book { height: 380px; width: 110px; }
        }
        @media (max-width: 768px) {
            .book { height: 330px; width: 100px; }
        }
        @media (max-width: 480px) {
            .book { height: 280px; width: 90px; }
        }
    </style>
</head>
<body>
    <nav class="navbar">
        <a href="Homepage.php" class="active">Home</a>
        <a href="Trackerpage.html">Tracker</a>
        <a href="Aboutpage.html">About</a>
    </nav>

    <div class="hero">
        <h2>Welcome to</h2>
        <h1><span>Edu</span>Trackr</h1>
        <button class="login-btn" data-bs-toggle="modal" data-bs-target="#loginModal">Login</button>
    </div>

    <div class="bookshelf" id="bookshelf"></div>

    <!-- Login Modal -->
    <div class="modal fade" id="loginModal" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="loginModalLabel">Student Login</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                <form action="login.php" method="POST">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name:</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                    </div>
                    <div class="mb-3">
                        <label for="studentID" class="form-label">Student ID:</label>
                        <input type="text" class="form-control" id="studentID" name="studentID" placeholder="Enter your Student ID" required>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-custom">Login</button>
                    </div>
                </form>
                </div>
            </div>
        </div>
    </div>

    <script>
        function generateBooks() {
            const bookshelf = document.getElementById('bookshelf');
            const screenWidth = window.innerWidth;
            let bookWidth;

            if (screenWidth <= 480) {
                bookWidth = 80;
            } else if (screenWidth <= 768) {
                bookWidth = 90;
            } else if (screenWidth <= 1200) {
                bookWidth = 110;
            } else {
                bookWidth = 120;
            }

            const numberOfBooks = Math.floor(screenWidth / bookWidth);
            bookshelf.innerHTML = '';
            bookshelf.style.gridTemplateColumns = `repeat(${numberOfBooks}, ${bookWidth}px)`;

            for (let i = 0; i < numberOfBooks; i++) {
                const book = document.createElement('div');
                book.classList.add('book');
                book.style.width = `${bookWidth}px`;
                bookshelf.appendChild(book);
            }
        }

        window.onload = generateBooks;
        window.onresize = generateBooks;

        document.getElementById('loginForm').addEventListener('submit', function(event) {
            event.preventDefault();
            const name = document.getElementById('name').value;
            const studentID = document.getElementById('studentID').value;

            if (name && studentID) {
                alert(`Welcome, ${name}! Student ID: ${studentID}`);
                document.getElementById('loginForm').reset();
            } else {
                alert('Please fill in both fields.');
            }
        });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
