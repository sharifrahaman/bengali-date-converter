# Bengali Date Converter
Bengali Calendar or Bangla Calendar is heavily used calendar in Bengal region. Specially in Bangladesh and West Bengal. But popularity of English calendar has dramatically increased in last couple of decades. There is direct relationship with revised Bengali calendar and English calendar. So I think it's high time to have an open API for Bengali to English and English to Bengali date conversion.

#Motivation
My brother Nazmul Huda told me that he knows his date of birth in Bengali date but he doesn't know the English date. He wants me to find out his English date of birth. I tried to find out online Bengali to English date converter. But I didn't find any Bengali Date Converter which is 100% comply with official Bengali Calendar. Beside this my grand father always asked me what is the Bengali date today? Unfortunately I never able to answer him instantly. Every time I checked Bengali calendar and answered him. Hence I came up with this project.

#Basic Rules of Bengali Calender
There are twelve months in Bengali calendar. Those are BOISHAKH, JYOISHTHO, ASHARH, SHRABON, BHADRO, ASHBIN, KARTIK, OGROHAYON, POUSH, MAGH, FALGUN and CHOITRO.
<ul>
<li>The first five months of the year from BOISHAKH to BHADRO will consist of 31 days each.</li>
<li>The remaining seven months of the year from ASHBIN to CHOITRO will consist of 30 days each.</li>
<li>In every leap year of the Gregorian calendar, an additional day will be added in the month of FALGUN</li>
</ul>

Source: <a href="https://en.wikipedia.org/wiki/Bengali_calendar">Wikipedia</a>

#Live Example

	<form name="banglaDateConverter" id="banglaDateConverter" method="post" action="#" onsubmit="return false;">
		<fieldset>
			<legend>Bengali Date Converter</legend>
			<p>
				<input type="radio" name="dateType" value="B" checked="checked" />
				English to Bengali Date 
				<input type="radio" name="dateType" value="E" /> 
				Bengali to English Date
			</p>
			<p>
				<select name="day" id="day">
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
				<select name="englishMonth" id="englishMonth">
					<option value="1">JANUARY</option>
					<option value="2">FEBRUARY</option>
					<option value="3">MARCH</option>
					<option value="4">APRIL</option>
					<option value="5">MAY</option>
					<option value="6">JUNE</option>
					<option value="7">JULY</option>
					<option value="8">AUGUST</option>
					<option value="9">SEPTEMBER</option>
					<option value="10">OCTOBER</option>
					<option value="11">NOVEMBER</option>
					<option value="12">DECEMBER</option>
				</select> 
				<select name="banglaMonth" id="banglaMonth" style="display: none;">
					<option value="1">BOISHAKH</option>
					<option value="2">JYOISHTHO</option>
					<option value="3">ASHARH</option>
					<option value="4">SHRABON</option>
					<option value="5">BHADRO</option>
					<option value="6">ASHBIN</option>
					<option value="7">KARTIK</option>
					<option value="8">OGROHAYON</option>
					<option value="9">POUSH</option>
					<option value="10">MAGH</option>
					<option value="11">FALGUN</option>
					<option value="12">CHOITRO</option>
				</select>
				<input type="text" name="year" id="year" placeholder="2000" />
				<input type="submit" id="convert" value="Convert" />
			</p>
			<p id="result">
			</p>
		</fieldset>
	</form>
