package com.merckmanuals;

/**
 * Created by Sergio on 10/22/17.
 */


    public enum URLStatus {

        HTTP_OK(200, "OK", "SUCCESS"), NO_CONTENT(204, "No Content", "SUCCESS"),
        MOVED_PERMANENTLY(301, "Moved Permanently", "SUCCESS"), NOT_MODIFIED(304, "Not modified", "SUCCESS"),
        USE_PROXY(305, "Use Proxy", "SUCCESS"), INTERNAL_SERVER_ERROR(500, "Internal Server Error", "ERROR"),
        NOT_FOUND(404, "Not Found", "ERROR");

        private int statusCode;
        private String httpMessage;
        private String result;

        public int getStatusCode() {
            return statusCode;
        }

        private URLStatus(int code, String message, String status) {
            statusCode = code;
            httpMessage = message;
            result = status;
        }

        public static String getStatusMessageForStatusCode(int httpcode) {
            String returnStatusMessage = "Status Not Defined";
            for (URLStatus object : URLStatus.values()) {
                if (object.statusCode == httpcode) {
                    returnStatusMessage = object.httpMessage;
                }
            }
            return returnStatusMessage;
        }

        public static String getResultForStatusCode(int code) {
            String returnResultMessage = "Result Not Defined";
            for (URLStatus object : URLStatus.values()) {
                if (object.statusCode == code) {
                    returnResultMessage = object.result;
                }
            }
            return returnResultMessage;
        }
    }