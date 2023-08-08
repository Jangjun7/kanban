package validators;

import models.works.Work;

public interface Validator<T> {
    void check(T t);
}
