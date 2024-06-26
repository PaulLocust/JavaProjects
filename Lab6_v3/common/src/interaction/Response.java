package interaction;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class for get response value.
 */
public class Response implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private final ResponseResult responseResult;
    private final String responseBody;

    public Response(ResponseResult responseResult, String responseBody) {
        this.responseResult = responseResult;
        this.responseBody = responseBody;
    }

    /**
     * @return Response result
     */

    public ResponseResult getResponseResult() {
        return responseResult;
    }

    /**
     *
     * @return Response body
     */
    public String getResponseBody() {
        return responseBody;
    }

    @Override
    public String toString() {
        return "Response[" + responseResult + ", " + responseBody + "]";
    }
}