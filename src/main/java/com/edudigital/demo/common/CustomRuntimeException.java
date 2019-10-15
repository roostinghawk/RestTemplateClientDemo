package com.edudigital.demo.common;

/**
 * @author liuwei
 * @date 2019/10/15
 */
public class CustomRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -6882178806561789418L;

    private final String code;
    private Object[] params;

    public CustomRuntimeException(final String code) {
        this.code = code;
    }

    public CustomRuntimeException(final String code, final Object... params) {
        this.code = code;
        this.params = params;
    }

    public CustomRuntimeException(final String code, final String defaultMessage) {
        super(defaultMessage);
        this.code = code;
    }

    public CustomRuntimeException(final String code, final String defaultMessage, final Object... params) {
        super(defaultMessage);
        this.code = code;
        this.params = params;
    }

    public CustomRuntimeException(final String code, final String defaultMessage, final Throwable cause) {
        super(defaultMessage, cause);
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public Object[] getParams() {
        return this.params;
    }
}

