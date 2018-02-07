<%@ include file="header.jsp"%>

		<title>Login | BananaGest</title>
		<link rel="stylesheet" type="text/css" href="css/csslogin.css">
	</head>
	<body>
		<header>
				<p class="bananagest">BANANA GEST
				<img src="images/bananas.png" class="logo"></p>
		</header>
		<main>
			<section class="entrar">
				<form action="login" method="post">
					<label for="name">Name<input class="input" name="name" type="text" placeholder="User name" maxlength="30" minlength="3" autofocus required />
					<label for="password">Password</label><input class="input" name="password" type="password" placeholder="*********" maxlength="12" minlength="4" required/>
					<input class="input" type="submit" value="Entrar" />
				</form>
					<p><a href="error_message.jsp">¿Olvidaste tu contraseña?</a></p>	
			</section>
		</main>
	</body>
		
<%@ include file="footer.jsp"%>		