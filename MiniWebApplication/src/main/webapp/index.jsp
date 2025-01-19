<!--try: alla html file ah yum,thani thani folder ah save panu
			 oru html file la irunthu innoru html ah  add pani call panara maari design pananau-->
		

<html>
	<head>
		<tittle>Welcome to Web App</tittle>
	</head>
	<body>
		<!-- for add user-->
		<h2> Add user Information</h2>
		<form action="addUser">
			Enter ID: <input type="text" name="id"><br>
			Enter Name: <input type="text" name="name"><br>
			
			<input type="submit"><br>
		</form>
		
		<!--for Display user-->
		<h2> Display user Information</h2>
		
		<form action="getUser">
			Enter ID: <input type="text" name="id"><br>					
			<input type="submit"><br>
		</form>
		<!--for delete user-->
		<h2> Delete user Information</h2>
		
		<form action="deleteUser">
			Enter ID: <input type="text" name="id"><br>					
			<input type="submit"><br>
		</form>
		<!--for update user-->
			<h2>update user Information</h2>
			
			<form action="updateUser">
				Enter ID: <input type="text" name="id"><br>					
				<input type="submit"><br>
			</form>

	</body>
</html>
		
