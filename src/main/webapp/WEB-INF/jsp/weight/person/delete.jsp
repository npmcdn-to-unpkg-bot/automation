<%@ include file="/WEB-INF/include.jsp"  %>

<h2>Delete Person</h2>

<form method="post" action="delete">
    <fieldset>
        <legend>Are you sure you want to delete this Person?</legend>
        <table class="table table-bordered table-hover">
            <thead>
                <tr>
                    <th>PersonId</th>
                    <th>EmailId</th>
                    <th>Password</th>
                    <th>FirstName</th>
                    <th>LastName</th>
                    <th>MiddleName</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>
                        ${ person.personId }
                    </td>
                    <td>
                        ${ person.emailId }
                    </td>
                    <td>
                        ${ person.password }
                    </td>
                    <td>
                        ${ person.firstName }
                    </td>
                    <td>
                        ${ person.lastName }
                    </td>
                    <td>
                        ${ person.middleName }
                    </td>
                </tr>
            </tbody>
        </table>

        <input type="submit" name="submit" value="Yes" class="btn btn-danger" />
        <input type="submit" name="submit" value="No" class="btn btn-default" />

        <input type="hidden" name="personId" value="${ person.personId }" />

    </fieldset>
</form>