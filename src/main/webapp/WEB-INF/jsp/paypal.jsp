<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>
<div>
    <p style="text-align: center"></p>
    <%--@elvariable id="cartItem" type="java"--%>
    <form:form id="paypal"
               method="POST"
               name="paypal"
               action="https://www.sandbox.paypal.com/cgi-bin/webscr"
               modelAttribute="cartItem">

        <input type="hidden" name="business" value="sb-86edp23434935@business.example.com" />
        <input type="hidden" name="cert_id" value="AdzdCJXXCwLuYPxc0eQAbeGs9Mk2w5ScN7zvIDpWWdRH7aGB0aA3AnBX11AUnmiD2jmu8zXrr9Vy7yWk" />
        <input type="hidden" name="cmd" value="_cart" />
        <input type="hidden" name="upload" value="1" />
        <c:forEach items="${ cart.getGames() }" var="cart" varStatus="status">
            <input type="hidden" name="quantity_${status.count}" value="${cart.value.getQuantity()}" />
            <input type="hidden" name="item_name_${status.count}" value="${cart.value.getGame().getName()}" />
            <input type="hidden" name="amount_${status.count}" value="${cart.value.getRealPrice()}" />
        </c:forEach>
        <input type="hidden" name="return" value="http://localhost:8082/boardgame/cart/paymentSuccess" />
        <input type="hidden" name="cancel_return" value="http://localhost:8082/boardgame/cart/paymentFailed" />
        <input type="hidden" name="currency_code" value="EUR" />
    </form:form>
    <script type="text/javascript">
        document.forms["paypal"].submit();
    </script>
</div>
