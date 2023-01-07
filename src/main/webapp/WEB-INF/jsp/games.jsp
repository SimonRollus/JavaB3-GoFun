<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>

<div style="text-align: center">
    <a href="<spring:url value='/home'/>" class="btn btn-ghost"><spring:message code="allgames"/></a>
    <c:forEach items="${categories}" var="category">
        <a href="<spring:url value="/category/${category.getCategory().getCategoryID()}"/>" class="btn btn-ghost">${category.getLabel()}</a>
    </c:forEach>
</div>

<div class="bg-white">
    <div class="mx-auto max-w-2xl py-16 px-4 sm:py-24 sm:px-6 lg:max-w-7xl lg:px-8">
        <h2 class="text-2xl font-bold tracking-tight text-gray-900"><spring:message code="games"/></h2>
        <div class="mt-6 grid grid-cols-1 gap-y-10 gap-x-6 sm:grid-cols-2 lg:grid-cols-4 xl:gap-x-8">
            <c:forEach items="${gamesCategoryID}" var="game">
                <div class="group relative">
                    <div class="min-h-80 aspect-w-1 aspect-h-1 w-full overflow-hidden rounded-md bg-gray-200 group-hover:opacity-75 lg:aspect-none lg:h-80">
                        <img src='<spring:url value="/images/${game.getImage()}"/>' class="h-full w-full object-cover object-center lg:h-full lg:w-full" loading="lazy">
                    </div>
                    <div class="mt-4 flex justify-between">
                        <div>
                            <h3 class="text-sm text-gray-700">
                                <a href='<spring:url value="/game/${game.getGameID()}"/>'>
                                <span aria-hidden="true" class="absolute inset-0"></span>
                                        ${game.getName()}
                                </a>
                            </h3>
                            <p class="mt-1 text-sm text-gray-500">${game.getDescription()}</p>
                        </div>
                        <c:if test="${!game.isOnDiscount()}">
                            <p class="text-sm font-medium text-gray-900">${game.getPrice()}0&euro;</p>

                        </c:if>
                        <c:if test="${game.isOnDiscount()}">
                            <label class="swap">
                                <input type="checkbox" />
                                <div class="swap-on"><p class="text-sm font-medium text-red-500">${game.getPriceWithDiscount()}&euro;</p></div>
                                <div class="swap-off"><p class="text-sm font-medium text-red-500 line-through">${game.getPrice()}&euro;</p></div>
                            </label>
                        </c:if>
                    </div>
                </div>
            </c:forEach>


        </div>
    </div>
</div>
