<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="#">Company name</a>
        <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse"
          data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false"
          aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
        <ul class="navbar-nav px-3">
          <li class="nav-item text-nowrap">
            <a class="nav-link" href="#">Sign out</a>
          </li>
        </ul>
      </header>
      
      
      
      

 
  <div class="container-fluid">
    <div class="row">
      <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
        <div class="position-sticky pt-3">
          <ul class="nav flex-column">
                      <li class="nav-item">
              <a class="nav-link" href="userList">
                <span data-feather="users"></span>
                user
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="productList">
                <span data-feather="shopping-cart"></span>
                Products
              </a>
            </li>            
            
            <li class="nav-item">
              <a class="nav-link" href="orderList">
                <span data-feather="file"></span>
                Orders
              </a>
            </li>


            <li class="nav-item">
              <a class="nav-link" href="#">
                <span data-feather="bar-chart-2"></span>
                Reports
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span data-feather="layers"></span>
                Integrations
              </a>
            </li>
          </ul>

          <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
            <span>Saved reports</span>
            <a class="link-secondary" href="#" aria-label="Add a new report">
              <span data-feather="plus-circle"></span>
            </a>
          </h6>
          <ul class="nav flex-column mb-2">
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span data-feather="file-text"></span>
                Current month
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span data-feather="file-text"></span>
                Last quarter
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span data-feather="file-text"></span>
                Social engagement
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">
                <span data-feather="file-text"></span>
                Year-end sale
              </a>
            </li>
          </ul>
        </div>
      </nav>





          <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div
              class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
              <h1 class="h2">회원관리</h1>
              <div class="btn-toolbar mb-2 mb-md-0">
              </div>
            </div>
            <c:if test="${not empty thisUser}">
            <form action="userUpdate" method="post">
              <div class="row">
              <h6>회원정보</h6>
              <input type="hidden" name="userNo" value="${thisUser.userNo}"/>
                <div class="col input-group mb-3">
                <span class="input-group-text" id="basic-addon1">이름</span>
                   <input type="text" class="form-control" name="name" aria-label="First name" value="${thisUser.name}">
                </div>
                <div class="col input-group mb-3">
                <span class="input-group-text" id="basic-addon1">닉네임</span>
                  <input type="text" class="form-control" name="nick" aria-label="First name" value="${thisUser.nick}">
                </div>
                <div class="col input-group mb-3">
                <span class="input-group-text" id="basic-addon1">이메일</span>
                  <input type="email" class="form-control" name="email" aria-label="First name" value="${thisUser.email}">
                </div>
                <div class="col input-group mb-3">
                <span class="input-group-text" id="basic-addon1">권한</span>
                  <input type="text" class="form-control" name="userTypeNo" aria-label="First name" value="${thisUser.userTypeNo}">
                </div>
                <div class="col input-group mb-3">
                  <button class="btn btn-dark indexBtn">변경</button>
                </div>
              </div>
            </form>
            </c:if>
            
            <div class="table-responsive">
              <table class="table table-striped table-sm">
                <thead>
                  <tr>
                    <th>번호</th>
                    <th>이름</th>
                    <th>닉네임</th>
                    <th>이메일</th>
                    <th>권한</th>
                  </tr>
                </thead>
                <tbody>
                  <c:forEach items="#{userList}" var='u'>
                    <tr class="form-tr" onclick="location.href='userDetail?no=${u.userNo}'">
                      <td>${u.userNo}</td>
                      <td>${u.name}</td>
                      <td>${u.nick}</td>
                      <td>${u.email}</td>
                      <td>${u.userTypeNo}</td>
                    </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </main>
        </div>
      </div>


      <script src="<%=request.getContextPath() %>/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>

      <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
        integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
        integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
        crossorigin="anonymous"></script>
      <script src="<%=request.getContextPath() %>/js/dashboard.js"></script>
  