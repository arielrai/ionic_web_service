angular.module('starter.controllers', [])

.controller('CadastrosCtrl', function($scope, $http) {
	$scope.cadastraUsuario = function(user){
		$http.post("http://localhost:8080/user", user).then(function(){
			console.log("salvo");
			delete user.email;
			delete user.usuario;
			delete user.senha;
		}, function(){
			
		});
	};
	$scope.cadastraPerson = function(person){
		$http.post("http://localhost:8080/person", person).then(function(){
			console.log("salvo");
			delete person.nome;
			delete person.rua;
			delete person.numero;
		}, function(){
			
		});
	};
})

.controller('PessoasCtrl', function($scope, $http) {
	$http.get("http://localhost:8080/person").then(function(response){
		$scope.people = response.data;
	}, function(){
		
	});
})

.controller('UsuariosCtrl', function($scope, $http) {
	$http.get("http://localhost:8080/user").then(function(response){
		$scope.users = response.data;
	}, function(){
		
	});
});
