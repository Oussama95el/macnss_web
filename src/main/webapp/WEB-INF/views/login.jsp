<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 05/12/2022
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<jsp:include page="../../components/navbar.jsp" flush="true"/>
<section class="h-screen">
    <div class="container px-6 py-12 h-full">
        <div class="flex justify-center items-center flex-wrap h-full g-6 text-gray-800">
            <div class="md:w-8/12 lg:w-6/12 p-8 mb-12 md:mb-0">
                <img
                        src="../../images/logo2.png"
                        class="w-1/2 mx-auto"
                        alt="Publicity MaCnss image"
                />
                <h1 class="text-4xl font-bold text-center mt-8 mb-4">
                    Chez <span class="underline text-cyan-700">MaCnss</span> nous vous accompagnons dans votre vie cotidienne...
                 </h1>
            </div>
            <div class="md:w-8/12 lg:w-5/12 lg:ml-20">
                <h1 class="text-4xl font-bold text-cyan-700 mb-4">
                    Login to MaCnss
                </h1>
                <form action="/login/user" method="post">
                    <!-- Email input -->
                    <div class="mb-6">
                        <label>
                            <select
                                    name="userType"
                                    class="form-control block w-full px-4 py-2 text-sm font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none">
                                <option class="text-grey-200" disabled selected><--Select Account Type--></option>
                                <option value="agent">Agent</option>
                                <option value="patient">Patient</option>
                            </select>
                        </label>
                    </div>
                    <!-- Email input -->
                    <div class="mb-6">
                        <label>
                            <input
                                    name="email"
                                    type="text"
                                    class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                    placeholder="Email address"
                            />
                        </label>
                    </div>

                    <!-- Password input -->
                    <div class="mb-6">
                        <label>
                            <input
                                    name="password"
                                    type="password"
                                    class="form-control block w-full px-4 py-2 text-xl font-normal text-gray-700 bg-white bg-clip-padding border border-solid border-gray-300 rounded transition ease-in-out m-0 focus:text-gray-700 focus:bg-white focus:border-blue-600 focus:outline-none"
                                    placeholder="Password"
                            />
                        </label>
                    </div>

                    <div class="flex justify-between items-center mb-6">
                        <div class="form-group form-check">
                            <label for="exampleCheck3"></label><input
                                    type="checkbox"
                                    class="form-check-input appearance-none h-4 w-4 border border-cyan-500 rounded-sm bg-white checked:bg-cyan-700 checked:border-cyan-600 focus:outline-none transition duration-200 mt-1 align-top bg-no-repeat bg-center bg-contain float-left mr-2 cursor-pointer"
                                    id="exampleCheck3"
                                    checked
                            />
                            <label class="form-check-label inline-block text-gray-800" for="exampleCheck3">
                                Remember me
                            </label
                            >
                        </div>
                        <a
                                href="#"
                                class="text-cyan-700 hover:text-cyan-900 focus:text-blue-700 active:text-blue-800 duration-200 transition ease-in-out"
                        >Forgot password?</a
                        >
                    </div>

                    <!-- Submit button -->
                    <button
                            type="submit"
                            class="inline-block px-7 py-3 bg-cyan-700 text-white font-medium text-sm leading-snug uppercase rounded shadow-md hover:bg-cyan-900 hover:shadow-lg focus:bg-cyan-700 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-cyan-800 active:shadow-lg transition duration-150 ease-in-out w-full"
                            data-mdb-ripple="true"
                            data-mdb-ripple-color="light"
                    >
                        Sign in
                    </button>

                </form>
            </div>
        </div>
    </div>
</section>
</body>
</html>
