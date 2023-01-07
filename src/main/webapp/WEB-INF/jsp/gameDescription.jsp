
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

<div style="text-align: center">
    <a href="<spring:url value='/home'/>" class="btn btn-ghost"><spring:message code="allgames"/></a>
    <c:forEach items="${categories}" var="category">
        <a href="<spring:url value="/category/${category.getCategory().getCategoryID()}"/>" class="btn btn-ghost">${category.getLabel()}</a>
    </c:forEach>
</div>
<body>
<div class="bg-white">
    <div class="pt-6">
        <!-- Image gallery -->
        <div class="mx-auto mt-6 max-w-2xl sm:px-6 lg:grid lg:max-w-7xl lg:grid-cols-3 lg:gap-x-8 lg:px-8">
            <div class="aspect-w-3 aspect-h-4 hidden overflow-hidden rounded-lg lg:block">
                <img src='<spring:url value="/images/${game.getImage()}"/>' alt="game" class="h-full w-full object-cover object-center">
            </div>
            <div class="hidden lg:grid lg:grid-cols-1 lg:gap-y-8">
                <div class="aspect-w-3 aspect-h-2 overflow-hidden rounded-lg">
                    <img src='<spring:url value="/images/games/general/box1.jpg"/>' alt="box1" class="h-full w-full object-cover object-center">
                </div>
                <div class="aspect-w-3 aspect-h-2 overflow-hidden rounded-lg">
                    <img src='<spring:url value="/images/games/general/box2.jpg"/>' alt="box2" class="h-full w-full object-cover object-center">
                </div>
            </div>
            <div class="aspect-w-4 aspect-h-5 sm:overflow-hidden sm:rounded-lg lg:aspect-w-3 lg:aspect-h-4">
                <img src='<spring:url value="/images/games/general/box3.jpg"/>' alt="box3" class="h-full w-full object-cover object-center">
            </div>
        </div>
        <!-- Product info -->
        <div class="mx-auto max-w-2xl px-4 pt-10 pb-16 sm:px-6 lg:grid lg:max-w-7xl lg:grid-cols-3 lg:grid-rows-[auto,auto,1fr] lg:gap-x-8 lg:px-8 lg:pt-16 lg:pb-24">
            <div class="lg:col-span-2 lg:border-r lg:border-gray-200 lg:pr-8">
                <h1 class="text-2xl font-bold tracking-tight text-gray-900 sm:text-3xl">${game.getName()}</h1>
            </div>
            <!-- Options -->
            <div class="mt-4 lg:row-span-3 lg:mt-0">
                <h2 class="sr-only">Product information</h2>
                <c:if test="${game.isOnDiscount()}">
                <p class="text-3xl tracking-tight text-red-500 line-through">${game.getPrice()}0&euro;</p>
                <p class="text-3xl tracking-tight text-gray-900">${game.getPriceWithDiscount()}&euro;</p>
                </c:if>
                <c:if test="${!game.isOnDiscount()}">
                    <p class="text-3xl tracking-tight text-gray-900">${game.getPrice()}&euro;</p>
                </c:if>

                <form:form id="addToCartForm"
                 method="POST"
                 action="/boardgame/cart/send"
                 modelAttribute="cartItem">
                <form class="mt-10">
                    <!-- Quantity -->
                    <div class="mt-10">
                        <div class="flex items-center justify-between">
                            <form:label path="quantity"><h3 class="text-sm font-medium text-gray-900"><spring:message code="quantity"/></h3></form:label>
                        </div>

                        <fieldset class="mt-4">
                            <div class="grid grid-cols-4 gap-4 sm:grid-cols-8 lg:grid-cols-4">
                                <!-- Active: "ring-2 ring-indigo-500" -->
                                <form:input type="number" min="1" max="99" value="1" path="quantity"></form:input>
                                <form:input type="hidden" value="${game.getGameID()}" path="gameID"></form:input>
                            </div>
                        </fieldset>
                    </div>
                    <form:button type="submit" class="mt-10 flex w-full items-center justify-center rounded-md border border-transparent bg-blue-600 py-3 px-8 text-base font-medium text-white hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"><spring:message code="addCart"/></form:button>
                </form>
                </form:form>
            </div>

            <div class="py-10 lg:col-span-2 lg:col-start-1 lg:border-r lg:border-gray-200 lg:pt-6 lg:pb-16 lg:pr-8">
                <!-- Description and details -->
                <div>
                    <h3 class="sr-only">Description</h3>

                    <div class="space-y-6">
                        <p class="text-base text-gray-900">${game.getDescription()}</p>
                    </div>
                </div>

                <div class="mt-10">
                    <h3 class="text-sm font-medium text-gray-900">Informations</h3>
                    <div class="mt-4">
                        <ul role="list" class="list-disc space-y-2 pl-4 text-sm">
                            <li class="text-gray-400"><span class="text-gray-600"><spring:message code="minimumAge"/> : ${game.getMinimumAge()}</span></li>

                            <li class="text-gray-400"><span class="text-gray-600"><spring:message code="numberMinPlayer"/> : ${game.getMinimumNumberPlayers()}</span></li>

                            <li class="text-gray-400"><span class="text-gray-600"><spring:message code="numberMaxPlayer"/> ${game.getMaximumNumberPlayers()}</span></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

