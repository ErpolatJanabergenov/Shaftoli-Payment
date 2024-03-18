package uz.pdp.shaftoli.service.transaction;

import uz.pdp.shaftoli.entity.TransactionEntity;
import uz.pdp.shaftoli.service.BaseService;

public interface TransactionService extends BaseService<TransactionEntity> {
    String addTransaction(TransactionEntity transaction);
}
