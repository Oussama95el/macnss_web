<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 07/12/2022
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient Form</title>
</head>
<body>
<div class="min-h-screen p-6 bg-gray-100 flex items-center justify-center">
  <div class="container max-w-screen-lg mx-auto">
    <div>
      <h2 class="font-semibold text-xl text-gray-600">Patient Form</h2>
      <p class="text-gray-500 mb-6">Form to register patient details.</p>

      <div class="bg-white rounded shadow-lg p-4 px-4 md:p-8 mb-6">
        <div class="grid gap-4 gap-y-2 text-sm grid-cols-1 lg:grid-cols-3">
          <div class="text-gray-600">
            <p class="font-medium text-lg">Personal Details</p>
            <p>Please fill out all the fields.</p>
          </div>
          <div class="lg:col-span-2">
            <form action="/register/patient" method="post" class="grid gap-4 gap-y-2 text-sm grid-cols-1 md:grid-cols-5">
              <div class="md:col-span-5">
                <label for="username">Full Name</label>
                <input type="text" name="username" id="username" class="h-10 border mt-1 rounded px-4 w-full bg-gray-50" value="" />
              </div>

              <div class="md:col-span-5">
                <label for="email">Email Address</label>
                <input type="text" name="email" id="email" class="h-10 border mt-1 rounded px-4 w-full bg-gray-50" value="" placeholder="email@domain.com" />
              </div>

              <div class="md:col-span-5">
                <label for="password">Password</label>
                <input type="password" name="password" id="password" class="h-10 border mt-1 rounded px-4 w-full bg-gray-50" value="" placeholder="***********" />
              </div>


              <div class="md:col-span-5 text-right">
                <div class="inline-flex items-end">
                  <input type="submit" class="bg-cyan-700 hover:bg-cyan-900 text-white font-bold py-2 px-4 rounded"/>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

  </div>
</div>


<script>
  // check if all enabled inputs are filled

</script>

</body>
</html>
