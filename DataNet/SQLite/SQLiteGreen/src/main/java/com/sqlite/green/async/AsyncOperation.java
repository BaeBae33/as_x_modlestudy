package com.sqlite.green.async;


import com.sqlite.green.common.AbstractSafelyDao;
import com.sqlite.green.common.IExecuteDao;
import com.sqlite.green.gen.DaoManager;

/**
 * 异步处理
 *
 * @author yline 2017/9/14 -- 16:09
 * @version 1.0.0
 */
public class AsyncOperation<Key, Model> {
    private AsyncOperationListener operationListener;

    private AbstractSafelyDao<Key, Model> abstractSafelyDao;

    public AsyncOperation(final AbstractSafelyDao<Key, Model> abstractSafelyDao) {
        this.abstractSafelyDao = abstractSafelyDao;
    }

    public void insert(final Model model) {
        DaoManager.getInstance().getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                long rowId = abstractSafelyDao.insert(model);
                if (null != operationListener) {
                    operationListener.onAsyncCompleted(new AsyncOperationModel(rowId, AsyncOperationType.Insert));
                }
            }
        });
    }

    public void insertInTx(final Iterable<Model> models) {
        DaoManager.getInstance().getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                abstractSafelyDao.insertInTx(models);
                if (null != operationListener) {
                    operationListener.onAsyncCompleted(new AsyncOperationModel(AsyncOperationType.InsertInTxIterable));
                }
            }
        });
    }

    public void insertInTx(final Iterable<Model> models, final boolean cache) {
        DaoManager.getInstance().getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                abstractSafelyDao.insertInTx(models, cache);
                if (null != operationListener) {
                    operationListener.onAsyncCompleted(new AsyncOperationModel(AsyncOperationType.InsertInTxIterableCache));
                }
            }
        });
    }

    public void insertOrReplace(final Model model) {
        DaoManager.getInstance().getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                abstractSafelyDao.insertOrReplace(model);
                if (null != operationListener) {
                    operationListener.onAsyncCompleted(new AsyncOperationModel(AsyncOperationType.InsertOrReplace));
                }
            }
        });
    }

    public void insertOrReplaceInTx(final Iterable<Model> models) {
        DaoManager.getInstance().getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                abstractSafelyDao.insertOrReplaceInTx(models);
                if (null != operationListener) {
                    operationListener.onAsyncCompleted(new AsyncOperationModel(AsyncOperationType.InsertOrReplaceInTxIterable));
                }
            }
        });
    }

    public void insertOrReplaceInTx(final Iterable<Model> models, final boolean cache) {
        DaoManager.getInstance().getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                abstractSafelyDao.insertOrReplaceInTx(models, cache);
                if (null != operationListener) {
                    operationListener.onAsyncCompleted(new AsyncOperationModel(AsyncOperationType.InsertOrReplaceInTxIterableCache));
                }
            }
        });
    }

    public void deleteAll() {
        DaoManager.getInstance().getExecutorService().execute(new Runnable() {
            @Override
            public void run() {
                abstractSafelyDao.deleteAll();
                if (null != operationListener) {
                    operationListener.onAsyncCompleted(new AsyncOperationModel(AsyncOperationType.DeleteAll));
                }
            }
        });
    }

    /**
     * 获取到这个对象之后，操作就是 非异步的
     *
     * @return 获取执行操作
     */
    public IExecuteDao<Key, Model> getExecuteDao() {
        return abstractSafelyDao;
    }

    /**
     * 每次操作完成，都会回掉回来
     *
     * @param operationListener 事件完成时，监听事件
     */
    public void setOnOperationListener(AsyncOperationListener operationListener) {
        this.operationListener = operationListener;
    }
}
