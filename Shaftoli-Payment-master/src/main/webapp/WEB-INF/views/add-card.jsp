<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!---Coding By CodingLab | www.codinglabweb.com--->
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link rel="stylesheet" href="<c:url value="/styles/add-card-style.css"/>" />
  </head>
  <body>
    <section class="container">
      <header>Add card form</header>
      <form action="/manage-cards/add-card/${owner}" method="post" class="form">

        <div class="input-box">
          <label>Card Number</label>
          <input type="hidden" name="owner" value="${owner}">
          <input type="text" name="cardNumber" placeholder="Enter card number" required />
        </div>

        <div class="input-box">
          <label>Password</label>
          <input type="password" name="password" placeholder="Enter card password" required />
        </div>

        <div class="input-box">
          <label>Balance</label>
          <input type="number" name="balance" placeholder="Enter card balance" required />
        </div>
          
        <div class="input-box">
          <label>Card type</label>
          <input type="text" name="type" placeholder="Select a card type" list="categories">
          <datalist id="categories">
            <option value="UZCARD">
            <option value="HUMO">
            <option value="VISA">
          </datalist>
        </div>

        <input type="hidden" name="status" value="true">
            
          
        <button>Submit</button>
      </form>
    </section>
  </body>
</html>