<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Landing Page With Light/Dark Mode</title>
    <link rel="stylesheet" href="<c:url value="/styles/menuStyle.css"/>" />
    <link rel="stylesheet" href="<c:url value="/styles/transaction-style.css"/>" />
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
                <li><a href="/history/${owner}"><h3>HISTORY</h3></a></li>
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

            <section class="container2">
              <h1 class="header2" style="font-family: 'Arial Rounded MT Bold'">TRANSACTION</h1>
              <p style="color: firebrick">${message}</p>
              <form action="/payment/${owner}" method="post" class="form">

                <div class="input-box">
                  <label>Card number</label>
                  <input type="text" name="receiverId" placeholder="Enter receiver card number" required />
                </div>

                <div class="input-box">
                  <label>Your card</label>
                  <input type="text" name="senderId" placeholder="Select a card type" list="categories">
                  <datalist id="categories">
                      <c:forEach items="${cards}" var="card">
                        <option value="${card.cardNumber}">
                      </c:forEach>
                  </datalist>
                </div>

                <div class="input-box">
                  <label>Summa</label>
                  <input type="number" name="amount" placeholder="Enter amount" required />
                </div>

                <button>Submit</button>
              </form>
            </section>

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
