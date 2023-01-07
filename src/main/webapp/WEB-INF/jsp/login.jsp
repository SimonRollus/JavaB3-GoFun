<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>


<div class="flex  items-center justify-center mt-6 py-12 px-4 sm:px-6 lg:px-8">
  <form:form id="connection"
             method="POST"
             modelAttribute="customerLogin">
  <div class="w-full max-w-md space-y-8">
    <div>
      <h2 class="mt-6 text-center text-3xl font-bold tracking-tight text-gray-900"><spring:message code="signinTitle"/></h2>
    </div>
    <form class="mt-8 space-y-6">
      <input type="hidden" name="remember" value="true">
      <div class="-space-y-px rounded-md shadow-sm">
        <div>
          <form:label path="username" class="sr-only"><spring:message code="username"/></form:label>
          <form:input path="username" name="username"  required="required" class="relative block w-full appearance-none rounded-none rounded-t-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-blue-500 focus:outline-none focus:ring-blue-500 sm:text-sm" placeholder="Username"></form:input>
        </div>
        <div>
          <form:label path="password" class="sr-only"><spring:message code="password"/></form:label>
          <form:input path="password" name="password" type="password" autocomplete="current-password" required="required" class="relative block w-full appearance-none rounded-none rounded-b-md border border-gray-300 px-3 py-2 text-gray-900 placeholder-gray-500 focus:z-10 focus:border-blue-500 focus:outline-none focus:ring-blue-500 sm:text-sm" placeholder="Password"></form:input>
        </div>
      </div>

      <div class="flex items-center justify-center">
        <div class="flex items-center">
          <input id="remember-me" name="remember-me" type="checkbox" class="h-4 w-4 rounded border-gray-300 text-indigo-600 focus:ring-indigo-500">
          <label for="remember-me" class="ml-2 block text-sm text-gray-900"><spring:message code="rememberMe"/></label>
        </div>

      </div>
      <div>
        <form:button class="group relative flex w-full justify-center rounded-md border border-transparent bg-blue-600 py-2 px-4 text-sm font-medium text-white hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-offset-2">
          <spring:message code="signin"/>
        </form:button>
      </div>
      <c:catch var="errorLogin">
            <span>${errorLogin}</span>
      </c:catch>
    </form:form>
  </div>
</div>
