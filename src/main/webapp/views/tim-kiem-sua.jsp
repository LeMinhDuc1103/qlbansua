<%-- 
    Document   : tim-kiem-sua
    Author     : hv
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fmt:setLocale value="vi-VN"/>
<div id="page4" class="main">
    <div class="col1 thuc-don">
        <%@include file="thuc-don.jsp"%>
    </div>
    <div class="col2">
    <form name="frmTimKiem" action="trang-tim-kiem-sua.jsp" method="post">
        <table border="1">
            <thead>
                <tr>
                    <th>TÌM KIẾM THÔNG TIN SỮA</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        Loại sữa: 
                        <select name="cboLoaiSua">
                            <c:forEach items="${dsls}" var="ls">
                                <option value="${ls.maLoaiSua}" ${param.cboLoaiSua==null?"":(param.cboLoaiSua eq ls.maLoaiSua?"selected":"")}>${ls.tenLoai}</option>
                            </c:forEach>
                        </select>
                        Hãng sữa:
                        <select name="cboHangSua">
                            <c:forEach items="${dshs}" var="hs">
                                <option value="${hs.maHangSua}" ${param.cboHangSua==null?"":(param.cboHangSua eq hs.maHangSua?"selected":"")}>${hs.tenHangSua}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Tên sữa: <input type="text" name="txtTenSuaTim" value="" size="30"/>
                        <input type="submit" value="Tìm kiếm" name="btnTimKiem"/>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>
    <c:if test="${soSP>0}">
        <p><b>Có ${soSP} sản phẩm được tìm thấy</b></p>
        <table border="0">
            <c:forEach items="${dsSua}" var="sua">
            <thead>
                <tr>
                    <th colspan="2" class="tieu-de-sua">${sua.tenSua }</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><img src="images/${sua.hinh}"></td>
                    <td>
                        <p><b>Thành phần dinh dưỡng:</b><br>${sua.tpDinhDuong }</p>
                        <p><b>Lợi ích:</b><br>${sua.loiIch }</p>
                        <fmt:formatNumber type="number" value="${sua.donGia}" var="donGia"/>
                        <p><b>Trọng lượng:</b> ${sua.trongLuong} gr - <b>Đơn giá:</b> ${donGia} đ</p>
                    </td>
                </tr>
            </tbody>
            </c:forEach>
        </table>
    </c:if>
    </div>
</div>