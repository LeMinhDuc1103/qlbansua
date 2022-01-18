<%-- 
    Document   : san-pham
    Author     : hv
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="page1" class="main">
    <div class="col1">
        <p id="sp">Sản phẩm theo hãng sữa</p>
        <ul>
            <c:forEach items="${dshs}" var="hs">
                <li><a href="trang-chu.jsp?maHang=${hs.maHangSua}">${hs.tenHangSua}</a></li>
            </c:forEach>
        </ul>
        <p>Sản phẩm theo loại</p>
        <ul>
            <c:forEach items="${dsls}" var="ls">
               <li><a href="trang-chu.jsp?maLoai=${ls.maLoaiSua}">${ls.tenLoai}</a></li>
            </c:forEach>
        </ul>
    </div>
    <div class="col2">
        <div class="thuc-don thuc-don-ngang">
            <%@include file="thuc-don.jsp"%>
        </div>
        <div class="col21">
            <table border="1" width="100%">
                <caption>DANH SÁCH SỮA</caption>
                <thead>
                    <tr>
                        <th>Hình</th>
                        <th>Tên sữa</th>
                        <th>Trọng lượng</th>
                        <th>Đơn giá</th>
                    </tr>
                </thead>
                <tbody>
                     <c:forEach items="${dss}" var="s">     
                    <tr>
                       	<td style="text-align: center;"><img src="images/${s.hinh}"/></td>
                       	<td><a href="trang-thong-tin-sua.jsp?maSua=${s.maSua}">${s.tenSua}</a></td>
                       	<td style="text-align: right;">${s.trongLuong} gr</td>
                       	<fmt:setLocale value="vi-VN"></fmt:setLocale>
                       	<fmt:formatNumber value="${s.donGia}" var="donGia" type="number"></fmt:formatNumber>
                       	<td style="text-align: right;">${donGia} đ</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <%-- <div class="danh-sach-trang">
            <c:if test="${tongSoTrang>1}">
                <c:forEach var="i" begin="1" end="${tongSoTrang}" step="1">
                    <c:if test="${!empty param.maHang}">
                        <a href="trang-chu.jsp?maHang=${param.maHang}&trang=${i}"> ${i} </a>
                    </c:if>
                    <c:if test="${!empty param.maLoai}">
                        <a href="trang-chu.jsp?maLoai=${param.maLoai}&trang=${i}"> ${i} </a>
                    </c:if>
                    <c:if test="${empty param.maHang && empty param.maLoai}">
                        <a href="trang-chu.jsp?trang=${i}"> ${i} </a>
                    </c:if>
                </c:forEach>
            </c:if>
            </div> --%>
        </div>
        <div class="col22">
            <%@include file="hinh-anh.html"%>
        </div>
    </div>
</div>