<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>������</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta http-equiv="imagetoolbar" content="no" />
 <link href="css/contents.css" rel="stylesheet" type="text/css" /> 
<link href="css/default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" 	src="https://code.jquery.com/jquery-3.5.0.min.js"></script>


<script >


	$(function() {
		$("a[lang='mod']").click(function(){		
			$.ajax({
				url:'adminInfo.do',
				datatype:'text',
				type:'post',
				data:{pk:this.id},
				success:function(data){	
					  $("#productName").val(data.productName);
					$("#productOrigin").val(data.productOrigin);
					$("#productPrice").val(data.productPrice);
					$("#productCategory").val(data.productCategory);
					$("#pk").val(this.id);
					$("#save").text("����");  
					 
				},
				error:function(){		
					alert('error');
				}			
			});
			
		});	
		 $("#save").click(function(){
			 var state=$("#save").text();
			 if(state=='����')$("form").attr("action","/web/adminModify.do");
			 $("form").submit();		 
		 });	
	});
	  	/* $("a[lang='mod']").click(function(){
	  		
			$.ajax({
				url:'adminInfo.do',
				datatype:'text',
				type:'post',
				data:{pk:this.id},
				success:function(data){	
					$("productName").val(data.productName);
					$("productOrigin").val(data.productOrigin);
					$("productPrice").val(data.productPrice);
					$("productCategory").val(data.productCategory);
					$("#pk").val(this.id); //pk�� hidden���� �Ѿ
					$("#save").text("����");
				},
				error:function(){		
					alert('error');
				}			
			});//ajax
			
		});	 

		$("a#save").click(function(){
			var state=$("#save").text();
			if(state=='����')$("form").attr("action","/web/adminModify.do");
			 $("form").submit();		 
		 });	
	}); */
</script>
</head>
<body> 
 

	<div id="wrap">
		<!-- header -->
		<jsp:include page="../include/topGnb.jsp"></jsp:include>
		<!--// header -->

		<div id="sub_container">
			<div id="contentsWrap" class="sub_con5">
				<div class="board_form">   
		            <div class="con_title">
		               <p>��ǰ���/����/����</p>   
		            </div>
			
			
			
				<div class="contents">
					<div class="btnSet clfix mgb15">
						<span class="fr"> <span class="button"><a href="#">���</a></span>
						</span>
					</div>

					<table class="bbsWrite mgb35">
						<caption></caption>
						<colgroup>
							<col width="95" />
							<col width="395" />
							<col width="95" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<th>��ü��</th>
								<td><select style="width: 200px;">
										<option>�����ϼ���</option>
								</select></td>
								<th>��ǰ��</th>
								<td><input type="text" name="" style="border:1px solid #ddd; height:20px;" class="inputText" size="30" />
									<span class="button"><a href="#">�˻�</a></span></td>
							</tr>
						</tbody>
					</table>

					<div class="clfix">
						<div class="tbWrapLt">
							<table class="bbsList">
								<colgroup>
									<col width="30" />
									<col width="100" />
									<col width="100" />
									<col width="100" />
									<col width="100" />
								</colgroup>
								<thead>								
								
									<tr>
										<th scope="col">NO.</th>
										<th scope="col">�̹���</th>
										<th scope="col">��ǰ��</th>
										<th scope="col">����</th>
										<th scope="col">����</th>
										
									</tr>
								</thead>

								<tbody>
								 <c:forEach var="i" items="${adminList}" varStatus="cnt"> 
									<tr>
										<td>${cnt.count}</td>
										<td><img src="/web/cartUp/${i.fileName}" width="50" height="50"/></td>
										<td>${i.productName}</td>
										<td>${i.productPrice}</td>																			
										<td>
										  <span class="buttonFuc"><a href="#" id="${i.pk}" lang="mod" >����</a></span>  
										<span class="buttonFuc"><a  href="deleteAdminProduct.do?pk=${i.pk}">����</a></span>
										</td>
									</tr>	
										</c:forEach>				

								</tbody>
							</table>
						</div>

						<div class="tbWrapRt">
							<ul class="tabA clfix mgb15">
								<li class="over"><a href="#info1">01. ��ǰ���</a></li>
							</ul>
 		              	<form action="productInsert.do" name="frm" method="post"  enctype="multipart/form-data">
							<div id="info1" class="tbWrapCnt" style="display: block;">
								<table class="bbsWrite mgb10">
									<caption></caption>
									<colgroup>
										<col width="95" />
										<col />
									</colgroup>
									<tbody>
										<tr>
											<th>��ǰ��</th>
											<td><input type="text" style="border:1px solid #ddd; height:20px;" name="productName" id="productName" class="inputText"
												size="50" /></td>
										</tr>
										 
										<tr>
											<th>������</th>
											<td><input type="text" style="border:1px solid #ddd; height:20px;" name="productOrigin" id="productOrigin" class="inputText"
												size="50" /></td>
										</tr>
										<tr>
											<th>��ǰ����</th>
											<td><input type="text" style="border:1px solid #ddd; height:20px;" name="productPrice" id="productPrice"  class="inputText"
												size="50" />
												<!-- <input type="hidden" name="pk" id="pk" /> -->
												<input type="hidden" name="id"  value="${id}"/>
								 
												</td>
										</tr>
										<tr>
											<th>ī�װ�</th>
											<td>
											<select style="width: 200px;" name="productCategory" id="productCategory">
												<option selected="selected">�����ϼ���</option>
												<option value="cloth">�Ƿ�/��ȭ</option>
												<option value="electronic">������ǰ</option>
												<option value="furniture">����</option>
												<option value="cosmetic">ȭ��ǰ/���</option>
												<option value="foods">��ǰ/�ַ�</option>
												<option value="car">������ǰ</option>													
											</select>
											</td>
										</tr>
										<tr>
											<th>��ǰ�̹���1</th>
											<td class="alignM"><input type="file" name="file"
												class="inputText" size="10" /></td>
										</tr>
									</tbody>
								</table>
							</div>
							</form>
						</div>

						<p class="agr">
							<span class="button"><a href="#" id="save">����</a></span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	
  <!--Footer-->
      <jsp:include page="../include/footer.jsp"></jsp:include>
   <!--END Footer-->	
   	</div>
	
</body>
</html>