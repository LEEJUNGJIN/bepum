<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login/Sign-In</title>
<link href="../css/loginstyle.css" type="text/css" rel="stylesheet" />
</head>

<body>
	<div class="logmod">
		<div class="logmod__wrapper">
			<!-- <span class="logmod__close" onclick="javascript:window.close();">Close</span> -->
			<div class="logmod__container">
				<ul class="logmod__tabs">
					<li data-tabtar="lgm-2"><a href="">로그인</a></li>
					<li data-tabtar="lgm-1"><a href="">회원가입</a></li>
				</ul>

				<div class="logmod__tab-wrapper">
					<div class="logmod__tab lgm-1">
						<!-- 회원가입 -->
						<div class="logmod__heading">
							<span class="logmod__heading-subtitle"> <strong>베:품
									회원가입</strong>
							</span>
						</div>
						<div class="logmod__form">
							<form method="post" name="loginInfo" accept-charset="utf-8" action="#" class="simform" onsubmit="return checkValue()">
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-name">이름 *</div>
										<input class="string optional" maxlength="10" id="user-name" name="name"
											placeholder="이름" type="text" size="50" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-name">아이디 *</div>
										<input class="string optional" maxlength="255" id="user-id" name="id"
											placeholder="아이디" type="text" size="50" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input string optional">
										<div class="string optional" for="user-pw">비밀번호 *</div>
										<input class="string optional" maxlength="255" id="user-pw" name="pw"
											placeholder="비밀번호" type="password" size="50" />
									</div>
									<div class="input string optional">
										<div class="string optional" for="user-pw-repeat">비밀번호확인
											*</div>
										<input class="string optional" maxlength="255"
											id="user-pw-repeat" placeholder="비밀번호확인" type="password" name="pw-re"
											size="50" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-name">이메일 *</div>
										<input class="string optional" maxlength="250" id="user-email" name="email"
											placeholder="이메일" type="email" size="50" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input string optional" id="user-gender">
										<div class="string optional" for="user-gender">성별 *</div>
										<label>남자<input class="option-input radio"
											name="gender" type="radio" value="1"></label>
									</div>
									<div class="input string optional">
										<div class="string optional" for="user-gender">
											<br />
										</div>
										<label>여자<input class="option-input radio"
											name="gender" type="radio" value="2" checked></label>
									</div>
								</div>

								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-birth">생년월일 *</div>
										<select aria-label="년" id="user_birthday_year"
											name="birthday_year">
											<option value="">년</option>
											<option value="2017">2017</option>
											<option value="2016">2016</option>
											<option value="2015">2015</option>
											<option value="2014">2014</option>
											<option value="2013">2013</option>
											<option value="2012">2012</option>
											<option value="2011">2011</option>
											<option value="2010">2010</option>
											<option value="2009">2009</option>
											<option value="2008">2008</option>
											<option value="2007">2007</option>
											<option value="2006">2006</option>
											<option value="2005">2005</option>
											<option value="2004">2004</option>
											<option value="2003">2003</option>
											<option value="2002">2002</option>
											<option value="2001">2001</option>
											<option value="2000">2000</option>
											<option value="1999">1999</option>
											<option value="1998">1998</option>
											<option value="1997">1997</option>
											<option value="1996">1996</option>
											<option value="1995">1995</option>
											<option value="1994">1994</option>
											<option value="1993">1993</option>
											<option value="1992">1992</option>
											<option value="1991">1991</option>
											<option value="1990">1990</option>
											<option value="1989">1989</option>
											<option value="1988">1988</option>
											<option value="1987">1987</option>
											<option value="1986">1986</option>
											<option value="1985">1985</option>
											<option value="1984">1984</option>
											<option value="1983">1983</option>
											<option value="1982">1982</option>
											<option value="1981">1981</option>
											<option value="1980">1980</option>
											<option value="1979">1979</option>
											<option value="1978">1978</option>
											<option value="1977">1977</option>
											<option value="1976">1976</option>
											<option value="1975">1975</option>
											<option value="1974">1974</option>
											<option value="1973">1973</option>
											<option value="1972">1972</option>
											<option value="1971">1971</option>
											<option value="1970">1970</option>
											<option value="1969">1969</option>
											<option value="1968">1968</option>
											<option value="1967">1967</option>
											<option value="1966">1966</option>
											<option value="1965">1965</option>
											<option value="1964">1964</option>
											<option value="1963">1963</option>
											<option value="1962">1962</option>
											<option value="1961">1961</option>
											<option value="1960">1960</option>
											<option value="1959">1959</option>
											<option value="1958">1958</option>
											<option value="1957">1957</option>
											<option value="1956">1956</option>
											<option value="1955">1955</option>
											<option value="1954">1954</option>
											<option value="1953">1953</option>
											<option value="1952">1952</option>
											<option value="1951">1951</option>
											<option value="1950">1950</option>
											<option value="1949">1949</option>
											<option value="1948">1948</option>
											<option value="1947">1947</option>
											<option value="1946">1946</option>
											<option value="1945">1945</option>
											<option value="1944">1944</option>
											<option value="1943">1943</option>
											<option value="1942">1942</option>
											<option value="1941">1941</option>
											<option value="1940">1940</option>
											<option value="1939">1939</option>
											<option value="1938">1938</option>
											<option value="1937">1937</option>
											<option value="1936">1936</option>
											<option value="1935">1935</option>
											<option value="1934">1934</option>
											<option value="1933">1933</option>
											<option value="1932">1932</option>
											<option value="1931">1931</option>
											<option value="1930">1930</option>
											<option value="1929">1929</option>
											<option value="1928">1928</option>
											<option value="1927">1927</option>
											<option value="1926">1926</option>
											<option value="1925">1925</option>
											<option value="1924">1924</option>
											<option value="1923">1923</option>
											<option value="1922">1922</option>
											<option value="1921">1921</option>
											<option value="1920">1920</option>
											<option value="1919">1919</option>
											<option value="1918">1918</option>
											<option value="1917">1917</option>
											<option value="1916">1916</option>
											<option value="1915">1915</option>
											<option value="1914">1914</option>
											<option value="1913">1913</option>
											<option value="1912">1912</option>
											<option value="1911">1911</option>
											<option value="1910">1910</option>
											<option value="1909">1909</option>
											<option value="1908">1908</option>
											<option value="1907">1907</option>
											<option value="1906">1906</option>
											<option value="1905">1905</option>
											<option value="1904">1904</option>
											<option value="1903">1903</option>
											<option value="1902">1902</option>
											<option value="1901">1901</option>
											<option value="1900">1900</option>
											<option value="1899">1899</option>
											<option value="1898">1898</option>
											<option value="1897">1897</option>
										</select> <select aria-label="월" id="user_birthday_month"
											name="birthday_month">
											<option value="">월</option>
											<option value="1">1월</option>
											<option value="2">2월</option>
											<option value="3">3월</option>
											<option value="4">4월</option>
											<option value="5">5월</option>
											<option value="6">6월</option>
											<option value="7">7월</option>
											<option value="8">8월</option>
											<option value="9">9월</option>
											<option value="10">10월</option>
											<option value="11">11월</option>
											<option value="12">12월</option>
										</select> <select aria-label="일" id="user_birthday_day"
											name="birthday_day">
											<option value="">일</option>
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31">31</option>
										</select>

									</div>
								</div>
								<div class="sminputs" style="text-align: right; font-size: 11px; border-bottom: none;">
									*표시 항목은 필수항목입니다.
								</div>
								

								<div class="simform__actions">
									<input type="submit" class="sumbit" name="commit" value="가입신청" />
								</div>
							</form>
						</div>
					</div>
					<div class="logmod__tab lgm-2">
						<!-- 로그인 -->
						<div class="logmod__heading">
							<a href=""><image src="../images/1616.png" id="logo" alt="베품" /></a>
							<span class="logmod__heading-subtitle"> <strong>아이디와
									비밀번호를 입력해주세요.</strong>
							</span>
						</div>
						<div class="logmod__form">
							<form accept-charset="utf-8" action="login" class="simform">
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-name">아이디*</div>
										<input class="string optional" maxlength="255" id="user-email"
											placeholder="아이디" type="text" size="50" name="id" />
									</div>
								</div>
								<div class="sminputs">
									<div class="input full">
										<div class="string optional" for="user-pw">비밀번호*</div>
										<input class="string optional" id="user-pw" placeholder="비밀번호"
											type="password" name="pwd"/>
										<!-- <span class="hide-password">Show</span> -->
									</div>
								</div>
								<div class="simform__actions">
									<input class="sumbit" name="commit" type="submit"
										value="Log In" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script src="../js/index.js"></script>
</body>
</html>



