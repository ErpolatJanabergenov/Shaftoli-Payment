<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Landing Page With Light/Dark Mode</title>
    <link rel="stylesheet" href="<c:url value="/styles/menuStyle.css"/>" />
    <link rel="stylesheet" href="<c:url value="/styles/p2p-style.css"/>" />

  </head>
  <body>
    <main>
      <div class="big-wrapper light">
        <img src="<c:url value="/styles/img/shape.png"/>" alt="" class="shape" />

        <header>
          <div class="container">
            <div class="logo">
              <img src="<c:url value="/styles/img/logo.png"/>" alt="Logo" />
              <h1 style="color: #ff7d00">SHAFTOLI</h1>
            </div>

            <div class="links">
              <ul>
                <li><a href="/manage-cards/${owner}"><h3>MANAGE CARDS</h3></a></li>
                <li><a href="/payment/${owner}"><h3>PAYMENT</h3></a></li>
                <li><a href="/p2p/${owner}"><h3>P2P</h3></a></li>
<!--                <li><a href="#" class="btn">Sign up</a></li>-->
              </ul>
            </div>

            <div class="overlay"></div>

            <div class="hamburger-menu">
              <div class="bar"></div>
            </div>
          </div>
        </header>

        <div class="showcase-area">
          <div class="container">
            <div class="table-showcase">
              <table class="content-table">
                <thead>
                <tr>
                  <th>SENDER</th>
                  <th>RECEIVER</th>
                  <th>AMOUNT</th>
                </tr>
                </thead>
                <tbody>

                <%--              <tr class="active-row">--%>
                <%--                <td>Sally</td>--%>
                <%--                <td>72,400</td>--%>
                <%--                <td></td>--%>
                <%--              </tr>--%>

                </tbody>
              </table>
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
    <script src="../../styles/app2.js"></script>
  </body>
</html>
