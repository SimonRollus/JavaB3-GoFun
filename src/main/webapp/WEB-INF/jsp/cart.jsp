<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

<div class="relative z-10" aria-labelledby="slide-over-title" role="dialog" aria-modal="true">
    <!--
      Background backdrop, show/hide based on slide-over state.

      Entering: "ease-in-out duration-500"
        From: "opacity-0"
        To: "opacity-100"
      Leaving: "ease-in-out duration-500"
        From: "opacity-100"
        To: "opacity-0"
    -->
    <div class="fixed inset-0 bg-gray-500 bg-opacity-75 transition-opacity"></div>

    <div class="fixed inset-0 overflow-hidden">
        <div class="absolute inset-0 overflow-hidden">
            <div class="pointer-events-none fixed inset-y-0 right-0 flex max-w-full pl-10">
                <!--
                  Slide-over panel, show/hide based on slide-over state.

                  Entering: "transform transition ease-in-out duration-500 sm:duration-700"
                    From: "translate-x-full"
                    To: "translate-x-0"
                  Leaving: "transform transition ease-in-out duration-500 sm:duration-700"
                    From: "translate-x-0"
                    To: "translate-x-full"
                -->
                <div class="pointer-events-auto w-screen max-w-md">
                    <div class="flex h-full flex-col overflow-y-scroll bg-white shadow-xl">
                        <div class="flex-1 overflow-y-auto py-6 px-4 sm:px-6">
                            <div class="flex items-start justify-between">
                                <h2 class="text-lg font-medium text-gray-900" id="slide-over-title"><spring:message code="cart"/></h2>
                                <div class="ml-3 flex h-7 items-center">
                                    <a href="<spring:url value='/home'/>" class="-m-2 p-2 text-gray-400 hover:text-gray-500">
                                        <span class="sr-only">Close panel</span>
                                        <!-- Heroicon name: outline/x-mark -->
                                        <svg class="h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="1.5" stroke="currentColor" aria-hidden="true">
                                            <path stroke-linecap="round" stroke-linejoin="round" d="M6 18L18 6M6 6l12 12" />
                                        </svg>
                                    </a>
                                </div>
                            </div>

                            <c:forEach items="${cart.getGames()}" var="cart">
                            <div class="mt-8">
                                <div class="flow-root">
                                    <ul role="list" class="-my-6 divide-y divide-gray-200">
                                        <li class="flex py-6">
                                            <div class="h-24 w-24 flex-shrink-0 overflow-hidden rounded-md border border-gray-200">
                                                <img src='<spring:url value="/images/${cart.value.getGame().getImage()}"/>' alt="Salmon orange fabric pouch with match zipper, gray zipper pull, and adjustable hip belt." class="h-full w-full object-cover object-center">
                                            </div>

                                            <div class="ml-4 flex flex-1 flex-col">
                                                <div>
                                                    <div class="flex justify-between text-base font-medium text-gray-900">
                                                        <h3>
                                                            <a>${cart.value.getGame().getName()}</a>
                                                        </h3>
                                                        <p class="ml-4">${cart.value.getGame().getPrice()}</p>
                                                    </div>

                                                </div>

                                                <div class="flex flex-1 items-end justify-between text-sm">
                                                    <form:form id = "quantityUpdateForm"
                                                    method="post"
                                                    action="/boardgame/cart/quantityUpdate"
                                                    modelAttribute="cartItem">
                                                        <form:label path="quantity"><p class="text-gray-500">Qty :</p></form:label>
                                                        <form:input type="number" min="1" max="99" value="${cart.value.getQuantity()}" path="quantity"></form:input>
                                                        <form:input type="hidden"  value="${cart.key}" path="gameID"></form:input>
                                                        <form:button type="submit" class="font-medium text-indigo-600 hover:text-indigo-500">Update</form:button>
                                                    </form:form>

                                                    <form:form id="removeItemForm"
                                                               method="POST"
                                                               action="/boardgame/cart/removeItem"
                                                               modelAttribute="cartItem">

                                                    <div class="flex">
                                                        <form:input type="hidden"  value="${cart.key}" path="gameID"></form:input>
                                                        <form:button type="submit" class="font-medium text-indigo-600 hover:text-indigo-500">Remove</form:button>
                                                    </div>
                                                    </form:form>
                                                </div>
                                            </div>
                                        </li>

                                    </ul>
                                </div>
                            </div>
                            </c:forEach>
                        </div>



                        <div class="border-t border-gray-200 py-6 px-4 sm:px-6">
                            <div class="flex justify-between text-base font-medium text-gray-900">
                                <p><spring:message code="subTotal"/></p>
                                <p>${cart.getTotalPrice()}&euro;</p>
                            </div>
                            <p class="mt-0.5 text-sm text-gray-500"><spring:message code="informationsCheckout"/></p>

                            <form:form id="buyForm"
                            method="POST"
                            action="/boardgame/cart/saveCart"
                            modelAttribute="cartItem">

                                <c:if test="${cart.getTotalPrice() > 0}">
                                <sec:authorize access="isAuthenticated()">
                                    <div class="mt-6 flex items-center justify-center rounded-md border border-transparent bg-blue-600 px-6 py-3 text-base font-medium text-white shadow-sm hover:bg-blue-700">
                                    <form:button type="submit"><spring:message code="checkout"/></form:button>
                                    </div>
                                </sec:authorize>
                                <sec:authorize access="!isAuthenticated()">
                                    <div class="mt-6 flex items-center justify-center rounded-md border border-transparent bg-blue-600 px-6 py-3 text-base font-medium text-white shadow-sm hover:bg-blue-700">
                                        <a href="<spring:url value='/login'/>"><spring:message code="signin"/></a>
                                    </div>
                                </sec:authorize>
                                </c:if>

                                <c:if test="${cart.getTotalPrice() <= 0}">
                                    <div class="mt-6">
                                        <a class="flex items-center justify-center rounded-md border border-transparent bg-blue-600 px-6 py-3 text-base font-medium text-white shadow-sm hover:bg-blue-700"><spring:message code="emptyCart"/></a>
                                    </div>
                                </c:if>


                            </form:form>

                            <div class="mt-6 flex justify-center text-center text-sm text-gray-500">
                                <p>
                                    <spring:message code="or"/>
                                    <a href="<spring:url value='/home'/>" class="font-medium text-blue-600 hover:text-blue-500">
                                        <spring:message code="continueShopping" />
                                        <span aria-hidden="true"> &rarr;</span>
                                    </a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

