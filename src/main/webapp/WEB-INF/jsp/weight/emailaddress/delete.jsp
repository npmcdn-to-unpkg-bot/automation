<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete EmailAddress</h2>

<form method="post" action="delete">
    <fieldset>
        <legend>Are you sure you want to delete this EmailAddress?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>EmailId</th>
                    <th>Address</th>
                    <th>Password</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ emailAddress.emailId }
                    </td>
                    <td>
                        ${ emailAddress.address }
                    </td>
                    <td>
                        ${ emailAddress.password }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="emailId" value="${ emailAddress.emailId }" />

    </fieldset>
</form>