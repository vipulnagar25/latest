package di;

public class Application {

    static void main(String[] args) throws Exception {

        SimpleDIContainer container = new SimpleDIContainer();

        container.register(PaymentService.class);
        container.register(OrderService.class);

        container.injectDependencies();

        OrderService orderService = container.getBean(OrderService.class);

        orderService.placeOrder();
    }
}