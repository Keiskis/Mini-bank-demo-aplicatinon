<!DOCTYPE html>
<html lang="en">
<head>
	<title>MINI BANK</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script src="js/angular.min.js"></script>
    <script src="js/main.js"></script>
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-178"  method = "post" action ="usersection">
					<span class="login100-form-title">
						MINI BANK RECKONING
					</span>
	<table ng-app="userSection" ng-controller = "AppCtrl" id="customers">
		<thead>
			<tr>
				<th scope="col">Deposit</th>
				<th scope="col">Withdrawal</th>
				<th scope="col">Balance</th>
			</tr>
		</thead>
		<tbody>
			<tr ng-repeat="item in websites">
				<td align = "center">{{item.deposit}}</td>
				<td align = "center">{{item.withdrawal}}</td>
				<td align = "center">{{item.balance}}</td>
			</tr>
		</tbody>
	</table>
				    <div class="text-right p-t-13 p-b-23">
					</div>
					<div class="wrap-input100 validate-input m-b-16" data-validate="Deposit mony">
						<input class="input100" type="text" name="depo" placeholder="Deposit">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Withdrawal money">
						<input class="input100" type="text" name="with" placeholder="Withdrawal">
						<span class="focus-input100"></span>
					</div>

					<div class="text-right p-t-13 p-b-23">
						
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Confirm operation
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>