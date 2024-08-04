<!DOCTYPE html>
<html>
<head>
    <title>Buy a T-Shirt</title>
</head>
<body>
    <h2>Buy a T-Shirt Online</h2>
    <form action="TShirtServlet" method="post">
        <label for="tagline">T-Shirt Tag-line:</label><br>
        <input type="text" id="tagline" name="tagline" required><br><br>
        
        <label>Accessories:</label><br>
        <input type="checkbox" name="accessory" value="Belt"> Belt<br>
        <input type="checkbox" name="accessory" value="Cap"> Cap<br>
        <input type="checkbox" name="accessory" value="Hair-band"> Hair-band<br><br>
        
        <label>T-Shirt Option:</label><br>
        <input type="radio" name="tShirtOption" value="With Chest Pocket" required> With Chest Pocket<br>
        <input type="radio" name="tShirtOption" value="Without Chest Pocket"> Without Chest Pocket<br><br>
        
        <label for="color">T-Shirt Color:</label><br>
        <select id="color" name="color" required>
            <option value="Red">Red</option>
            <option value="Blue">Blue</option>
            <option value="Green">Green</option>
        </select><br><br>
        
        <input type="submit" value="Click Me">
    </form>
</body>
</html>
