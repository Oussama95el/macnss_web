<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<jsp:include page="components/navbar.jsp" flush="true" />

<div class="flex p-8 mx-auto">

    <div class="flex flex-col justify-center items-start h-screen w-[50%] py-3 px-4 mb-3">
        <h1 class="text-blue-900 text-xl mb-3">Macnss Proteger vous et vous proches</h1>
        <p class="text-sm text-slate-600 mb-6">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>
        <a href="/login" class="w-1/2 rounded text-center bg-cyan-700 py-2 px-4 font-bold text-white hover:bg-sky-900">Login</a>
    </div>
    <div class="w-[50%] h-screen py-10 px-10">
        <img class="w-auto h-auto" src="/images/5e356a610a8fd.jpg" alt="logo cnss">
    </div>
</div>

<div>
    <jsp:include page="components/registerPatientForm.jsp"  flush="true" />
</div>


</body>
</html>