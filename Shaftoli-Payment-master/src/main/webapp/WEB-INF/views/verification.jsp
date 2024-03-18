<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Landing Page With Light/Dark Mode</title>
    <link rel="stylesheet" href="<c:url value="/styles/style2.css"/>" />
  </head>
  <body>
    <main>
      <div class="big-wrapper light">
        <header>
          <div class="container">
            <div class="logo">
              <img src="<c:url value="/styles/img/logo.png"/>" alt="Logo" />
              <h1 style="color: #dc2f02">Shaftoli</h1>
            </div>
          </div>
        </header>

        <div class="showcase-area">
          <div class="container">
            <div class="left">
              <div class="big-title">
                <h1>Verification</h1>
              </div>
              <p class="text">Emailingizga(${user.email}) kod yuborildi. Kodni kiritib emailingizni tasdiqlang!</p>
              <p style="color: red">${massage}</p>
                <form action="/auth/sign-up/verification/${user.id}" method="post" class="sign-up-form">
                <div  class="input-field">
                    <i class="fas fa-lock"></i>
                    <input type="hidden" name="userEmail" value="${user.email}">
                    <input type="hidden" name="user" value="${user}">
                    <input type="text" name="emailCode" placeholder="Enter verification code" />
                </div>
                <div style="text-align: left; margin-left : 120px; margin-top: 30px;">
                <button class="btn" >Submit</button>
                </div>
            </form>
            </div>

            <div class="right">
              <img src="<c:url value="/styles/img/person.png"/>" alt="Person Image" class="person" />
            </div>
          </div>
        </div>

        <div class="bottom-area">
          <div class="container">
            <button class="toggle-btn">
              <i class="far fa-moon"></i>
              <i class="far fa-sun"></i>
            </button>
          </div>
        </div>
      </div>
    </main>

    <!-- JavaScript Files -->

    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <script src="${pageContext.request.contextPath}/styles/app2.js"></script>
  </body>
</html>
