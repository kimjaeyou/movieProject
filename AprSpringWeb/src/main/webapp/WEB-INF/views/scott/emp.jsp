<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<style>
	div{float: left;
		padding:3px;
		}
	

</style>

<title>사원 장보확인</title>

</head>
<body>
	리스트<br>
	<h4>부서와 사원 확인</h4>
	<div>
	<select name="dept" id="dept">
	<option value="">부서 선택</option>
	<c:forEach items="${selectEmp}" var="emp">
		<option value="${emp.deptno}">${emp.dname}</option>
	</c:forEach> 
	</select>
	</div>
	
	<div id="second"></div><br><br><br>
	
	<div id="third"></div>
	
	<script src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<script type="text/javascript">
	$(function(){
		$("#dept").change(function(){
			$("#second,#third").empty();
			if($(this).val() ==""){
				alert("부서를 선택하세요");
				return false;
			}
			let deptno=$(this).val();
			
			$.ajax({
				  url: '/emps/'+deptno,
				  type: 'get',
				  dataType: 'json'
				  })
				  .done( function(response) {
					  let ops="<select id='emps'>";
					  for(let i in response){
						  ops+="<option value='"+response[i].empno+"'>"+response[i].ename+"</option>";
						  
					  }
					  ops+="</select>"
					  
				    $("#second").append(ops);
				  })
			
		})//change
		
		$("#second").on("change","#emps",function(){//나중에 바뀌면 추가
			$("#third").empty();
			let empno =$(this).val();
			$.ajax({
				  url:'/emp/'+empno,
				  type: 'get',
				  dataType: 'json'
				  })
				  .done( function(response) {
				    let emp = "사원 번호 : "+response.empno+"<br>";
				    emp +=  "사원 이름 : "+response.ename+"<br>";
				    emp +=  "사원 직급 : "+response.job+"<br>";
				    emp +=  "사원 급여 : "+response.sal+"<br>";
				    emp +=  "사원 입사일 : "+response.hiredate+"<br>";
				    $("#third").append(emp);
				  })
				  
		})//emps change
	})
	</script>
</body>
</html>