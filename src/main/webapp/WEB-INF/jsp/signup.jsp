<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="include/importTags.jsp"%>


<div class="mx-28 my-28">
    <h2 class="mt-3 text-center text-3xl font-bold tracking-tight text-gray-900"><spring:message code="signUp"/></h2>

    <div class="md:col-span-2 md:mt-3">

            <form:form id="signup"
            method="post"
            action="/boardgame/signup"
            modelAttribute="currentUser">

                <div class="overflow-hidden shadow sm:rounded-md">
                    <p style="color:red;font-weight: bolder">${customerExists}</p>
                    <div class="bg-white px-4 py-5 sm:p-6">
                        <div class="grid grid-cols-6 gap-6">
                            <div class="col-span-6 sm:col-span-3">
                                <form:label path="firstName" class="block text-sm font-medium text-gray-700" ><spring:message code="firstName"/></form:label>
                                <form:input path="firstName"  required="required" autocomplete="given-name" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"></form:input>
                                <form:errors path="firstName" cssClass="errors"/>
                            </div>

                            <div class="col-span-6 sm:col-span-3">
                                <form:label path="lastName" class="block text-sm font-medium text-gray-700"><spring:message code="lastName"/></form:label>
                                <form:input path="lastName"  required="required" autocomplete="given-name" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"></form:input>
                                <form:errors path="lastName" cssClass="errors"/>
                            </div>

                            <div class="col-span-6 sm:col-span-3">
                                <form:label path="username" class="block text-sm font-medium text-gray-700"><spring:message code="username"/></form:label>
                                <form:input path="username"  required="required" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"></form:input>
                                <form:errors path="username" cssClass="errors"/>
                            </div>

                            <div class="col-span-6 sm:col-span-4">
                                <form:label path="email" class="block text-sm font-medium text-gray-700">Email</form:label>
                                <form:input path="email" type="email" required="required" autocomplete="given-name" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"></form:input>
                                <form:errors path="email" cssClass="errors"/>
                            </div>

                            <div class="col-span-6 sm:col-span-4">
                                <form:label path="phoneNumber" class="block text-sm font-medium text-gray-700"><spring:message code="phoneNumber"/></form:label>
                                <form:input path="phoneNumber" type="tel" required="required" placeholder="0123-456-789"  autocomplete="given-name" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"></form:input>
                                <form:errors path="phoneNumber" cssClass="errors"/>
                            </div>

                            <div class="col-span-6">
                                <form:label path="address" class="block text-sm font-medium text-gray-700"><spring:message code="address"/></form:label>
                                <form:input path="address" required="required"  autocomplete="given-name" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"></form:input>
                                <form:errors path="address" cssClass="errors"/>
                            </div>

                            <div class="col-span-6 sm:col-span-3">
                                <form:label path="statut" class="block text-sm font-medium text-gray-700"><spring:message code="status"/></form:label>
                                <form:select path="statut" class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm">
                                    <form:option value="null"><spring:message code="selectStatus"/></form:option>
                                    <form:option value="individual"><spring:message code="individual"/></form:option>
                                    <form:option value="company"><spring:message code="company"/></form:option>
                                </form:select>
                            </div>

                            <div class="col-span-6">
                                <form:label path="password" class="block text-sm font-medium text-gray-700"><spring:message code="password"/></form:label>
                                <form:password path="password" required="required"  class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"></form:password>
                                <form:errors path="password" cssClass="errors"/>
                            </div>

                            <div class="col-span-6">
                                <form:label path="confirmPassword" class="block text-sm font-medium text-gray-700"><spring:message code="confirmPassword"/></form:label>
                                <form:password path="confirmPassword" required="required"  class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-500 focus:ring-indigo-500 sm:text-sm"></form:password>
                                <form:errors path="confirmPassword" cssClass="errors"/>
                            </div>

                        </div>
                    </div>
                    <div class="bg-gray-50 px-4 py-3 text-right sm:px-6">
                        <form:button type="submit" class="inline-flex justify-center rounded-md border border-transparent bg-blue-600 py-2 px-4 text-sm font-medium text-white shadow-sm hover:bg-blue-700 focus:outline-none focus:ring-2 focus:ring-indigo-500 focus:ring-offset-2"><spring:message code="signUp"/></form:button>
                    </div>
                </div>

    </form:form>
    </div>
</div>


