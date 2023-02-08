<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Simple Calculator</h2>
<br/>
<form method="post" action="/calculate">
    <fieldset>
        <table>
            <tr>
                <td>Calculator</td>
                <td></td>
            </tr>
            <tr>
                <td><label>First operand: </label></td>
                <td><input type="number" name="firstOpera" /></td>
            </tr>
            <tr>
                <td>Operator:</td>
                <td>
                    <select name="operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label>Second operand: </label></td>
                <td><input type="number" name="secondOpera" /></td>
            </tr>
            <tr>
                <td></td>
                <td colspan="2">
                    <input type = "submit" id = "submit" value="Calculate"/>
                </td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>