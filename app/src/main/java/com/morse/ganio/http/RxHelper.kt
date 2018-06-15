package com.morse.ganio.http;


import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class RxHelper {

    companion object {
        /**
         * 统一线程处理
         * <p>
         * 发布事件io线程，接收事件主线程
         */
        fun <T : Any?> rxSchedulerHelper(): ObservableTransformer<T, T> {
//            return ObservableTransformer<T, T> {
//                it
//            }
            //compose处理线程
            return ObservableTransformer<T, T>() {
                it
//                fun apply(upstream: Observable<T>): ObservableSource<T> {
//                    return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
//                }
            }
        }

        /**
         * 生成Flowable
         *
         * @param t
         * @return Flowable
         */
        fun <T : Any?> createFlowable(t: T?): Flowable<T> {
            return Flowable.create(FlowableOnSubscribe<T>() {
                @Throws(Exception::class)
                fun subscribe(emitter: FlowableEmitter<T>) {
                    try {
                        emitter.onNext(t!!);
                        emitter.onComplete();
                    } catch (e: Exception) {
                        emitter.onError(e);
                    }
                }
            }, BackpressureStrategy.BUFFER);
        }

        /**
         * 生成Observable
         *
         * @param t
         * @return Flowable
         */
        fun <T : Any?> createObservable(t: T): Observable<T> {
            return Observable.create(ObservableOnSubscribe<T>() {
                @Throws(Exception::class)
                fun subscribe(emitter: ObservableEmitter<T>) {
                    try {
                        emitter.onNext(t);
                        emitter.onComplete();
                    } catch (e: Exception) {
                        emitter.onError(e);
                    }
                }
            });
        }
    }
}
